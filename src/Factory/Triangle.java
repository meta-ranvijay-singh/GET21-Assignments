package Factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Factory.Shape.shapeType;

public class Triangle implements Shape {

	private double area, perimeter;
	private Date date;
	private Point originPoint;
	private shapeType type;
	private List<Integer> list;

	public Triangle(shapeType type, Point point, List<Integer> list)
			throws CloneNotSupportedException {
		originPoint = (Point) point.clone();
		date = Calendar.getInstance().getTime();
		this.list = list;

		perimeter = list.get(0) + list.get(1) + list.get(2);

		double s = perimeter / 2;

		area = Math.sqrt(s * (s - list.get(0)) * (s - list.get(1))
				* (s - list.get(2)));

		this.type = type;
	}

	@Override
	public double getArea() {
		return area;
	}

	@Override
	public Point getOrigin() throws CloneNotSupportedException {
		return (Point) originPoint.clone();
	}

	@Override
	public double getPerimeter() {
		return perimeter;
	}

	@Override
	public boolean isPointEnclosed(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public shapeType getType() {
		return type;
	}

	@Override
	public List<Integer> getList() {
		List<Integer> tempList = new ArrayList<Integer>();
		for (int data : list) {
			tempList.add(data);
		}
		return tempList;
	}

	@Override
	public void display() {
		System.out.println("\nType :" + type);
		System.out.println("Origin Point " + originPoint.toString());
		System.out.printf("Area :%.2f", area);
		System.out.printf("\nPerimeter :%.2f", perimeter);
		System.out.println("\nTime Stamp : " + date);

	}

}
