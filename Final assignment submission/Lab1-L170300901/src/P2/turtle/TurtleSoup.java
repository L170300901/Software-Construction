/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P2.turtle;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
       turtle.forward(40);
       turtle.turn(90);
       turtle.forward(40);
       turtle.turn(90);
       turtle.forward(40);
       turtle.turn(90);
       turtle.forward(40);
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
        double angle = ((double) sides-2)*180/(double)sides;
        
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
    	 try{
            turtle.turn(270);
            double angle = 360.0 - calculateRegularPolygonAngle(sides);
            for(int i = 0; i < sides; i++){
                turtle.forward(sideLength);
                turtle.turn(angle);
            }
        }catch(Exception e) {
            throw new RuntimeException("implement me!");
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
    /*public static double calculateBearingToPoint(double currentBearing, int currentX, int currentY,
                                                 int targetX, int targetY) {
    	int xkor = targetX - currentX;
    	int ykor = targetY - currentY;
    	
    	int terget = (int) (Math.atan2(xkor, ykor)*(180/Math.PI));
    	
    	
    	if(currentBearing != 0 && terget == 0) {
    		terget = 360;
    	}
    	if(xkor<0) {
    		terget += 360;	
    	}
    	
    	
    	return terget - currentBearing; 
    }*/
    
    public static double calculateBearingToPoint(double currentBearing, int currentX, int currentY,
            int targetX, int targetY) {
   
	double angle;
	angle=Math.atan(Math.abs((double)(((double)targetY-(double)currentY)/((double)targetX-(double)currentX))));
	angle=angle*(double)180/Math.PI;
	if(targetY>currentY)
	{
	if(targetX>currentX)
	{
	angle=(double)90-angle;
	angle=angle-currentBearing;
	if(angle<0)
	{
	angle+=(double)360;
	}
	}
	else if(targetX<currentX)
	{
	angle=(double)270+angle;
	angle=angle-currentBearing;
	if(angle<0)
	{
	angle+=(double)360;
	}
	}
	else
	{
	angle=(double)360-currentBearing;
	angle=angle%(double)360;
	}
	}
	else if(targetY<currentY)
	{
	if(targetX>currentX)
	{
	angle=(double)90+angle;
	angle=angle-currentBearing;
	if(angle<0)
	{
	angle+=(double)360;
	}
	}
	else if(targetX<currentX)
	{
	angle=(double)270-angle;
	angle=angle-currentBearing;
	if(angle<0)
	{
	angle+=(double)360;
	}
	}
	else
	{
	angle=(double)540-currentBearing;
	angle=angle%(double)360;
	}
	}
	else
	{
	if(targetX>currentX)
	{
	angle=(double)450-currentBearing;
	angle=angle%(double)360;
	}
	else if(targetX<currentX)
	{
	angle=(double)630-currentBearing;
	angle=angle%(double)360;
	}
	else
	{
	return 0;
	}
	}
	return angle;
	
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
        
    	List<Double> list1 = new ArrayList<Double>();
    	
        double angle1=0,angle2 = 0;
   	
   	for(int i=0 ; i<xCoords.size()-1 ; i++) {
   		
   		angle2 = calculateBearingToPoint(angle1, xCoords.get(i), yCoords.get(i), xCoords.get(i+1), yCoords.get(i+1));
   		angle1 += angle2;
   		
   		list1.add(angle2);
   	}
   	
   	return list1;
    	
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
        Point p0,p1;
        p0=new Point(0,0);
        p1=new Point(0,0);
        double dis,an1,an2,an3;
        ArrayList<Point> list1=new ArrayList<Point>();
        Set<Point> list2 = new HashSet<>();
           if(points.size()<=3)
           {
            return points;
           }
           else
           {
            for(Point p:points)
            {
             dis=p.x()*p.x()+p.y()*p.y();
             if(dis>p0.x()*p0.x()+p0.y()*p0.y())
             {
              p0=p;
             }
            }
         list1.add(p0);
         an1=361;
         for(Point p:points)
            {
             an2=calculateBearingToPoint(0,(int)p0.x(),(int)p0.y(),(int)p.x(),(int)p.y());
             
   	if(an2<an1&&(p!=p0))
             {
              an1=an2;
              p1=p;
             }
   	}
   	list1.add(p1);
         an1=361;
         for(int i=0;i<points.size();i++)
         {
          an3=calculateBearingToPoint(0,(int)list1.get(list1.size()-2).x(),(int)list1.get(list1.size()-2).y(),(int)list1.get(list1.size()-1).x(),(int)list1.get(list1.size()-1).y());
          an1=361;
          for(Point p:points)
          {
           an2=calculateBearingToPoint(an3,(int)list1.get(list1.size()-1).x(),(int)list1.get(list1.size()-1).y(),(int)p.x(),(int)p.y());
           if(an2<an1&&(p!=list1.get(list1.size()-1)))
                 {
                  an1=an2;
                  p1=p;
                 }
          }
          if(p1==list1.get(0))
          {
           break;
          }
          else
          {
           if(an1==0)
           {
            list1.remove(list1.size()-1);
           }
           list1.add(p1);
          }
         }
         
         for(Point p:list1)
         {
          list2.add(p);
         }
         return list2;
           }
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
        throw new RuntimeException("implement me!");
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

        drawSquare(turtle, 40);

        // draw the window
        turtle.draw();
    }

}
