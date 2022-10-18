/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package turtle;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class TurtleSoup {

    
	

	/**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
    	 
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
        
    }

    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
        
    	double angle = (((double) sides-2)*180)/(double) sides;
    	
    	
    	return (Math.round(angle*100)/100.0);
    			
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
        
    	double sides =  (360/(180-angle));
    	return (int) (Math.round(sides));
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
        
    	for(int i=0;  i<sides;  i++) {
    		
    		/*if(i == 0) {
    			
    			turtle.turn(calculateRegularPolygonAngle(sides));
    		}*/
    	    turtle.forward(sideLength);
    	    turtle.turn(180-calculateRegularPolygonAngle(sides));
    		
    	}
    	
    }

    /**
     * Given the current direction, current location, and a target location, calculate the Bearing
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentBearing. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentBearing current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to Bearing (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateBearingToPoint(double currentBearing, int currentX, int currentY,
                                                               int targetX, int targetY){
       
    	int xcod = targetX - currentX;//为了求tan的值
    	int ycod = targetY - currentY;
    	
    	int targetBearing = (int) (Math.atan2(xcod, ycod)*(180/Math.PI));//Y-axis criteria angular
    	
    	
    	if(xcod<0) {
    		targetBearing += 360;	
    	}//because of negative value,if x are inside number two,three -quadrant plane +360
    	
    	if(targetBearing == 0 && currentBearing != 0) {
    		targetBearing = 360;
    	}//the situation that isn't 0 angle 
    	
    	
    	return targetBearing - currentBearing; 
    }

    /**
     * Given a sequence of points, calculate the Bearing adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateBearingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of Bearing adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateBearings(List<Integer> xCoords, List<Integer> yCoords) {
    	
    	List<Double> listFirst = new ArrayList<Double>();
    	
    	
         double angle1=0,angle2 = 0;
    	
    	for(int i=0 ; i<xCoords.size()-1 ; i++) {
    		
    		angle2 = calculateBearingToPoint(angle1, xCoords.get(i), yCoords.get(i), xCoords.get(i+1), yCoords.get(i+1));
    		angle1 += angle2;
    		angle1 = angle1 % 360;
    	    
    		listFirst.add(angle2);
    	}
    	
    	return listFirst;
    }       

    
    /**
     * Given a set of points, compute the convex hull, the smallest convex set that contains all the points 
     * in a set of input points. The gift-wrapping algorithm is one simple approach to this problem, and 
     * there are other algorithms too.
     * 
     * @param points a set of points with xCoords and yCoords. It might be empty, contain only 1 point, two points or more.
     * @return minimal subset of the input points that form the vertices of the perimeter of the convex hull
     */

	
	
    public static Set<Point> convexHull(Set<Point> points) {
		
    	Set<Point> convexHull1 = new HashSet<Point>(); 
        List<Point> points1 = new ArrayList<Point>(points);
        
        
        

       if(points1.size() > 0) {//자료가 하나라도 있을때
    	   
        double minY = points1.get(0).y();
    	int numberofMinY = 0;
    	
    	 for(int i=1; i<points1.size(); i++) {
         	
         	
         if(points1.get(i).y() == minY)	{
        	 
        	 if(points1.get(i).x() > points1.get(numberofMinY).x()) {
        		 minY = points1.get(i).y();
        		 numberofMinY = i;
        	 }
         }
         	
    	 else if(points1.get(i).y() < minY) {
         		
         		minY = points1.get(i).y();
         		numberofMinY = i;
         		
         	}
         }//y가 가장작고 x가 가장큰 포인트 구하기

		
    	
    	 
}
       return null;
    }

    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {
       
    	
    	for(int i=0; i<8; i++) {
    		drawRegularPolygon(turtle,7,80);
    		turtle.forward(80);
    		turtle.turn(80);
    	}
    }

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();

               drawPersonalArt(turtle);
       

        // draw the window
        turtle.draw();
    }

}
