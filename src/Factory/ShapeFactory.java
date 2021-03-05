package Factory;

import java.util.List;

import Factory.Shape.shapeType;

public class ShapeFactory {
	public Shape getInstance(shapeType type, Point point, List<Integer> list)
			throws CloneNotSupportedException {

		switch (type) {
		case CIRCLE:
			return new Circle(type, point, list);

		case TRIANGLE:
			return new Triangle(type, point, list);
		case RECTANGLE:
			return new Rectangle(type, point, list);

		case SQUARE:
			return new Square(type, point, list);
		default:
			return null;
		}

	}
}
