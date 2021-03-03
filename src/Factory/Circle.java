package Factory;

import java.util.Calendar;
import java.util.Date;


public class Circle implements Shape{
	private double area,perimeter,radius;
	private Date date;
	private Point point;
	private double PI=3.14;


	public Circle(Point p, double r) throws CloneNotSupportedException  {
		// TODO Auto-generated constructor stub
		point=(Point)p.clone();
		date=Calendar.getInstance().getTime();
		radius=r;
		area=PI*r*r;
		perimeter=2*PI*r;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return area;
	}

	@Override
	public Point getOrigin() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Point)point.clone();
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return perimeter;
	}

	@Override
	public boolean isPointEnclosed(Point p) {
		// TODO Auto-generated method stub
		if ( Math.pow( p.getX() - point.getX() ,2 ) + Math.pow( p.getY() - point.getY() ,2 )  <= Math.pow(radius, 2) )
		        return true; 
		    else
		        return false; 
	}
	
}
