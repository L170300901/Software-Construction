package Solarsystem;

public class CircularOrbitAPI<L,E> {

	double getPhysicalDistance (ConcreteCircularOrbit<L,E> S, Planet e1, Planet e2) {
		
		double angle1,angle2;
		double x1,y1;
		double x2,y2;
		
		if(Math.abs(S.presentAngle(e1)) >= 90 && Math.abs(S.presentAngle(e2)) >= 90) {
			//x축을 기준으로 부호가 바뀌니 y축만 보면된다 y좌표가 둘다 위에있을 때，以x轴为标准, 符号变了, 只看y轴就行 y坐标两个都在上面的时候
				
	        	angle1 = S.presentAngle(e1);
	        	angle2 = S.presentAngle(e2);
	        
	        	if(S.presentAngle(e1) > 0) {//180도를 넘어가면 부호가 마이너스로 바뀌기 때문에 
	        		x1 = e2.getOrbitradius()*(((angle1-90.0)/(double)90));//90도 이하의 수로 만들어준 후 계산
	        		y1 = e2.getOrbitradius()*(1.0-(Math.abs(angle1-90/(double)90)));
	        	}
	        	else{
	        		x1 = e2.getOrbitradius()*(((angle1+90.0)/(double)90));
	        		y1 = e2.getOrbitradius()*(1.0-(Math.abs(angle1+90/(double)90)));
	        	}
	        	
	        	if(S.presentAngle(e2) > 0) {
	        		x2 = e2.getOrbitradius()*(((angle2-90.0)/(double)90));
	        		y2 = e2.getOrbitradius()*(1.0-(Math.abs(angle2-90/(double)90)));
	        	}
	        	
	        	else{
	        		x2 = e2.getOrbitradius()*(((angle2+90.0)/(double)90));
	        		y2 = e2.getOrbitradius()*(1.0-(Math.abs(angle2+90/(double)90)));
	        	}
	        	
	        	return Math.sqrt(Math.pow((Math.abs(x2-x1)),2.0) + Math.pow((Math.abs(y2-y1)),2.0));
			}
        else if(Math.abs(S.presentAngle(e1)) >= 90 && Math.abs(S.presentAngle(e2)) < 90) {
			// 첫번째 y좌표는 위에 두번째 y좌표는 아래에 잇을때，第一个y座标是上第二个y座标在下面的时候
        	
        	angle1 = S.presentAngle(e1);
        	angle2 = S.presentAngle(e2);
        	
        	if(S.presentAngle(e2) > 0) {
        		x1 = e2.getOrbitradius()*(((angle1-90.0)/(double)90));
        		y1 = e2.getOrbitradius()*(1.0-(Math.abs(angle1-90/(double)90)));
        	}
        	else{
        		x1 = e2.getOrbitradius()*(((angle1+90.0)/(double)90));
        		y1 = e2.getOrbitradius()*(1.0-(Math.abs(angle1+90/(double)90)));
        	}
        	
        	x2 = e1.getOrbitradius()*((angle2/(double)90));
			y2 = e1.getOrbitradius()*(1.0-(Math.abs(angle2/(double)90)));
			
			return Math.sqrt(Math.pow((Math.abs(x2-x1)),2.0) + Math.pow((y1+(Math.abs(y2-y1))),2.0));
		}
        else if(Math.abs(S.presentAngle(e1)) < 90 && Math.abs(S.presentAngle(e2)) < 90) {
			//둘다 아래에 있을 때，两个都在下面的时候
        	
        	angle1 = S.presentAngle(e1);
        	angle2 = S.presentAngle(e2);
        	
        	x1 = e1.getOrbitradius()*((angle1/(double)90));
			y1 = e1.getOrbitradius()*(1.0-(Math.abs(angle1/(double)90)));
			x2 = e2.getOrbitradius()*((angle2/(double)90));
			y2 = e2.getOrbitradius()*(1.0-(Math.abs(angle2/(double)90)));
			
			return Math.sqrt(Math.pow((Math.abs(x2-x1)),2.0) + Math.pow((Math.abs(y2-y1)),2.0));
		}
        else if(Math.abs(S.presentAngle(e1)) < 90 && Math.abs(S.presentAngle(e2)) >= 90) {
			// 첫번째 y좌표는 위에 두번재 y좌표는 아래에 있을 때，第一个y座标是上第二个y座标在下面的时候
        	
        	angle1 = S.presentAngle(e1);
        	angle2 = S.presentAngle(e2);
        	if(S.presentAngle(e2) > 0) {
        		x2 = e2.getOrbitradius()*(((angle2-90.0)/(double)90));
        		y2 = e2.getOrbitradius()*(1.0-(Math.abs(angle2-90/(double)90)));
        	}
        	else{
        		x2 = e2.getOrbitradius()*(((angle2+90.0)/(double)90));
        		y2 = e2.getOrbitradius()*(1.0-(Math.abs(angle2+90/(double)90)));
        	}
        	
        	x1 = e1.getOrbitradius()*((angle1/(double)90));
			y1 = e1.getOrbitradius()*(1.0-(Math.abs(angle1/(double)90)));
			
			return Math.sqrt(Math.pow((Math.abs(x2-x1)),2.0) + Math.pow((y2+(Math.abs(y2-y1))),2.0));
		}
        else {
        	return -1;
        }
		
	}
}
