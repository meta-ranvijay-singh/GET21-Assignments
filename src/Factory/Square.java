package Factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Factory.Shape.shapeType;

public class Square implements Shape{
	private double area,perimeter;
	private Date date;
	private Point originPoint;
	private shapeType type;
	private List<Integer> list;

	
	public Square(shapeType type, Point point, List<Integer> list)  throws CloneNotSupportedException  {
		originPoint=(Point)point.clone();
		date=Calendar.getInstance().getTime();
		this.list=list;
		area=list.get(0) * list.get(0);
		perimeter=4 * list.get(0);
		this.type=type;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point getOrigin() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Point)originPoint.clone();
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return perimeter;
	}

	@Override
	public boolean isPointEnclosed(Point passPoint) {
		// TODO Auto-generated method stub
		if( passPoint.getX() > originPoint.getX() && passPoint.getX() < (originPoint.getX()+list.get(0)) && passPoint.getY() > originPoint.getY() && passPoint.getY() < ( originPoint.getY()+list.get(1) ) ){
			return true;
		}
		return false;
	}

	@Override
	public shapeType getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public List<Integer> getList(){
		List<Integer> tempList=new ArrayList<Integer>();
		for(int data:list){
			tempList.add(data);
		}
		return tempList;
	}
	

	@Override
	public void display() {
		System.out.println("\nType :"+type);
		System.out.println("Origin Point "+originPoint.toString());
		System.out.printf("Area :%.2f",area);
		System.out.printf("\nPerimeter :%.2f",perimeter);
		
	}

}
