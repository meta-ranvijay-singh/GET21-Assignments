package Factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;


public class Circle implements Shape {
	private double area, perimeter;
	private Date date;
	private Point originPoint;
	private double PI = 3.14;
	private shapeType type;
	private List<Integer> list;

	/**
	 * Circle constructor initializing its data member.
	 * @param shapeType type store type of shape, Point point origin point,
	 * List<Integer> list store radius
	 */
	public Circle(shapeType type, Point point, List<Integer> list)
			throws CloneNotSupportedException {
		originPoint = (Point) point.clone();
		date = Calendar.getInstance().getTime();
		this.list = list;
		area = PI * list.get(0) * list.get(0);
		perimeter = 2 * PI * list.get(0);
		this.type = type;
	}

	/**
	 * Method to get radius.
	 * @return tempList radius.
	 */
	public List<Integer> getList() {
		List<Integer> tempList = new ArrayList<Integer>();
		for (int data : list) {
			tempList.add(data);
		}
		return tempList;
	}

	/**
	 * Method to return area circle.
	 * @return area of circle
	 */
	@Override
	public double getArea() {
		return area;
	}

	/**
	 * Method to return type of circle.
	 * @return type of circle
	 */
	@Override
	public shapeType getType() {
		return type;
	}

	/**
	 * Method to return origin point of circle.
	 * @return point, origin point of circle
	 */
	@Override
	public Point getOrigin() throws CloneNotSupportedException {
		return (Point) originPoint.clone();
	}

	/**
	 * Method to get perimeter of circle.
	 * @return perimeter of circle
	 */
	@Override
	public double getPerimeter() {
		return perimeter;
	}

	/**
	 * Method to check if point is inside the circle.
	 * @return true if point is inside the circle otherwise else
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		if (Math.pow(point.getX() - originPoint.getX(), 2)
				+ Math.pow(point.getY() - originPoint.getY(), 2) <= Math.pow(
				list.get(0), 2))
			return true;
		else
			return false;
	}

	/**
	 * Method to display circle properties.
	 */
	@Override
	public void display() {
		System.out.println("\nType :" + type);
		System.out.println("Origin Point " + originPoint.toString());
		System.out.printf("Area :%.2f", area);
		System.out.printf("\nPerimeter :%.2f", perimeter);
		System.out.println("\nTime Stamp : " + date);
	}

}
