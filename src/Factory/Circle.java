package Factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;


public class Circle implements Shape {
	private double area,perimeter;
	private Date date;
	private Point originPoint;
	private double PI=3.14;
	private shapeType type;
	private List<Integer> list;

	public Circle(shapeType type, Point point, List<Integer> list) throws CloneNotSupportedException  {
		originPoint=(Point)point.clone();
		date=Calendar.getInstance().getTime();
		this.list=list;
		area=PI*list.get(0)*list.get(0);
		perimeter=2*PI*list.get(0);
		this.type=type;
	}
	
	public List<Integer> getList(){
		List<Integer> tempList=new ArrayList<Integer>();
		for(int data:list){
			tempList.add(data);
		}
		return tempList;
	}
	
	@Override
	public double getArea() {
		return area;
	}
	
	@Override
	public shapeType getType(){
		return type;
	}

	@Override
	public Point getOrigin() throws CloneNotSupportedException {
		return (Point)originPoint.clone();
	}

	@Override
	public double getPerimeter() {
		return perimeter;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		if ( Math.pow( point.getX() - originPoint.getX() ,2 ) + Math.pow( point.getY() - originPoint.getY() ,2 )  <= Math.pow(list.get(0), 2) )
		        return true; 
		    else
		        return false; 
	}

	@Override
	public void display() {
		System.out.println("\nType :"+type);
		System.out.println("Origin Point "+originPoint.toString());
		System.out.printf("Area :%.2f",area);
		System.out.printf("\nPerimeter :%.2f",perimeter);
	}
	
}
