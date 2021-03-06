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
	private List<Point> sidePoints;

	/**
	 * Triangle constructor initializing its data member.
	 * @param shapeType type store type of shape, Point point origin point,
	 * List<Integer> list store its three side
	 */
	public Triangle(shapeType type, Point point, List<Integer> list, List<Point> sidePoints)
			throws CloneNotSupportedException {
		originPoint = (Point) point.clone();
		date = Calendar.getInstance().getTime();
		this.list = list;

		perimeter = list.get(0) + list.get(1) + list.get(2);

		double s = perimeter / 2;

		area = Math.sqrt(s * (s - list.get(0)) * (s - list.get(1))
				* (s - list.get(2)));

		this.type = type;
		this.sidePoints=sidePoints;
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
	public boolean isPointEnclosed(Point passedPoint) {
		
		double A = area(originPoint, sidePoints.get(0), sidePoints.get(1));
		double A1 = area(passedPoint, sidePoints.get(0), sidePoints.get(1));
		double A2 = area(originPoint, passedPoint, sidePoints.get(1));
		double A3 = area(originPoint, sidePoints.get(0), passedPoint);

		return (A == A1 + A2 + A3);

	}
	
	/**
	 * Support Method for isPointEnclosed() to find area.
	 * @return area using three point
	 */
	private double area(Point point1, Point point2, Point point3) {
		return Math.abs((point1.getX() * (point2.getY() - point3.getY())
				+ point2.getX() * (point3.getY() - point1.getY()) + point3
				.getX() * (point1.getY() - point2.getY())) / 2.0);
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
