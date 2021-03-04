package Factory;

public class Point implements Cloneable{
	private double point_x,point_y;
	
	public Point(double x, double y) {
		point_x=x;
		point_y=y;
	}
	
	public double getX(){
		return point_x;
	}
	
	public double getY(){
		return point_y;
	}
	
	public boolean isEqual(Point passedPoint){
		if(point_x == passedPoint.getX()){
			if(point_y == passedPoint.getY()){
				return true;
			}
		}
		
		return false;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public String toString(){
		return "(x,y) : ("+point_x+", "+point_y+")";
	}
}
