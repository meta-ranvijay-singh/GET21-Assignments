package Factory;

import java.util.List;

import Factory.Shape.shapeType;

/**
 * Factory class that return the object of different shapes on the basis of
 * shape type
 */
public class ShapeFactory {
	public Shape getInstance(shapeType type, Point point, List<Integer> list, List<Point> sidePoints)
			throws CloneNotSupportedException {

		switch (type) {
		case CIRCLE:
			return new Circle(type, point, list);

		case TRIANGLE:
			return new Triangle(type, point, list, sidePoints);
		case RECTANGLE:
			return new Rectangle(type, point, list);

		case SQUARE:
			return new Square(type, point, list);
		case REGULAR_POLYGON:
			return new RegularPoly(type, point, list, sidePoints);
		default:
			return null;
		}

	}
}
