package Factory;

public class Point implements Cloneable{
	private double X,Y;
	
	public Point(double x, double y) {
		X=x;
		Y=y;
	}
	
	double getX(){
		return X;
	}
	
	double getY(){
		return Y;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
