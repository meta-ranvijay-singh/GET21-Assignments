package Factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Factory.Shape.shapeType;

public class Rectangle implements Shape {
	private double area, perimeter;
	private Date date;
	private Point originPoint;
	private shapeType type;
	private List<Integer> list;

	/**
	 * Rectangle constructor initializing its data member.
	 * 
	 * @param shapeType
	 *            type store type of shape, Point point origin point,
	 *            List<Integer> list store length and width
	 */
	public Rectangle(shapeType type, Point point, List<Integer> list)
			throws CloneNotSupportedException {
		originPoint = (Point) point.clone();
		date = Calendar.getInstance().getTime();
		this.list = list;
		area = list.get(0) * list.get(1);
		perimeter = 2 * (list.get(0) + list.get(1));
		this.type = type;
	}

	/**
	 * Method to return area rectangle.
	 * 
	 * @return area of rectangle
	 */
	@Override
	public double getArea() {
		return area;
	}

	/**
	 * Method to get its origin point.
	 * 
	 * @return origin point of rectangle
	 */
	@Override
	public Point getOrigin() throws CloneNotSupportedException {
		return (Point) originPoint.clone();
	}

	/**
	 * Method to return perimeter rectangle.
	 * 
	 * @return perimeter of rectangle
	 */
	@Override
	public double getPerimeter() {
		return perimeter;
	}

	/**
	 * Method to check if point is inside the rectangle.
	 * 
	 * @return true if point is inside the rectangle otherwise else
	 */
	@Override
	public boolean isPointEnclosed(Point passPoint) {
		if (passPoint.getX() > originPoint.getX()
				&& passPoint.getX() < (originPoint.getX() + list.get(0))
				&& passPoint.getY() > originPoint.getY()
				&& passPoint.getY() < (originPoint.getY() + list.get(1))) {
			return true;
		}
		return false;
	}

	/**
	 * Method to type of shape.
	 * 
	 * @return type of shape
	 */
	@Override
	public shapeType getType() {
		return type;
	}

	/**
	 * Method to get list of its sides.
	 * 
	 * @return tempList having length and width.
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
	 * Method to display rectangle properties.
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
