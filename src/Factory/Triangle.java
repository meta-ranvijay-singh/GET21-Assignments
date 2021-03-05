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

	/**
	 * Triangle constructor initializing its data member.
	 * @param shapeType type store type of shape, Point point origin point,
	 * List<Integer> list store its three side
	 */
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

	/**
	 * Method to return area triangle.
	 * @return area of triangle
	 */
	@Override
	public double getArea() {
		return area;
	}

	/**
	 * Method to origin point of triangle.
	 * @return origin point of triangle
	 */
	@Override
	public Point getOrigin() throws CloneNotSupportedException {
		return (Point) originPoint.clone();
	}

	/**
	 * Method to get perimeter of triangle.
	 * @return perimeter of triangle
	 */
	@Override
	public double getPerimeter() {
		return perimeter;
	}

	/**
	 * Method to check if point is inside the triangle.
	 * @return true if point is inside the triangle otherwise else
	 */
	@Override
	public boolean isPointEnclosed(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Method to get type of shape.
	 * @return type of shape
	 */
	@Override
	public shapeType getType() {
		return type;
	}

	/**
	 * Method to get sides of triangle.
	 * @return tempList sides of triangle.
	 */
	@Override
	public List<Integer> getList() {
		List<Integer> tempList = new ArrayList<Integer>();
		for (int data : list) {
			tempList.add(data);
		}
		return tempList;
	}

	/**
	 * Method to display triangle properties.
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
