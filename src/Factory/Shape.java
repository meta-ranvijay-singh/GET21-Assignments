package Factory;

import java.util.Comparator;
import java.util.List;

/**
 * Shape interface
 */
public interface Shape {
	enum shapeType {
		CIRCLE, RECTANGLE, SQUARE, TRIANGLE
	};

	double getArea();

	Point getOrigin() throws CloneNotSupportedException;

	double getPerimeter();

	boolean isPointEnclosed(Point p);

	shapeType getType();

	List<Integer> getList();

	void display();

}

/**
 * Class used to sort list of shape type on the basis of area in ascending order
 */
class sortByArea implements Comparator<Shape> {
	public int compare(Shape shape1, Shape shape2) {
		return shape2.getArea() < shape1.getArea() ? 1 : -1;
	}
}

/**
 * Class used to sort list of shape type on the basis of perimeter in ascending
 * order
 */
class sortByPerimeter implements Comparator<Shape> {
	public int compare(Shape shape1, Shape shape2) {
		return shape1.getPerimeter() > shape2.getPerimeter() ? 1 : -1;
	}
}

/**
 * Class used to sort list of shape type on the basis of distance from origin in
 * ascending order
 */
class sortByOrigin implements Comparator<Shape> {
	public int compare(Shape shape1, Shape shape2) {
		double distance1, distance2;
		try {
			distance1 = Math.sqrt(Math.pow(shape1.getOrigin().getX(), 2)
					+ Math.pow(shape1.getOrigin().getY(), 2));
			distance2 = Math.sqrt(Math.pow(shape2.getOrigin().getX(), 2)
					+ Math.pow(shape2.getOrigin().getY(), 2));

			return distance1 > distance2 ? 1 : -1;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}
}
