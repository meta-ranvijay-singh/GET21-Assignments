package Factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Factory.Shape.shapeType;

public class Square implements Shape {
	private double area, perimeter;
	private Date date;
	private Point originPoint;
	private shapeType type;
	private List<Integer> list;

	/**
	 * Square constructor initializing its data member.
	 * 
	 * @param shapeType
	 *            type store type of shape, Point point origin point,
	 *            List<Integer> list store side length
	 */
	public Square(shapeType type, Point point, List<Integer> list)
			throws CloneNotSupportedException {
		originPoint = (Point) point.clone();
		date = Calendar.getInstance().getTime();
		this.list = list;
		area = list.get(0) * list.get(0);
		perimeter = 4 * list.get(0);
		this.type = type;
	}

	/**
	 * Method to get area.
	 * 
	 * @return tempList area.
	 */
	@Override
	public double getArea() {
		return area;
	}

	/**
	 * Method to get origin point.
	 * 
	 * @return origin point.
	 */
	@Override
	public Point getOrigin() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Point) originPoint.clone();
	}

	/**
	 * Method to get perimeter.
	 * 
	 * @return perimeter.
	 */
	@Override
	public double getPerimeter() {
		return perimeter;
	}

	/**
	 * Method to check if point is inside the square.
	 * 
	 * @return true if point is inside the square otherwise else
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
	 * Method to get type of shape.
	 * 
	 * @return type of shape.
	 */
	@Override
	public shapeType getType() {
		return type;
	}

	/**
	 * Method to get length of side.
	 * 
	 * @return tempList list having its length of side.
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
	 * Method to display square properties.
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
