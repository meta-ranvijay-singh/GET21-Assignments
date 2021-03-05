package Factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Factory.Shape.shapeType;

public class Screen {
	private Point screenEndPoint;
	List<Shape> shapes;

	/**
	 * Screen constructor initializing Max Screen points.
	 * 
	 * @param point
	 *            of Point class
	 */
	public Screen(Point point) throws CloneNotSupportedException {
		shapes = new ArrayList<Shape>();
		screenEndPoint = (Point) point.clone();
	}

	/**
	 * Method to add shapes to the screen.
	 * 
	 * @param shapeType
	 *            type store type of shape, Point point origin point,
	 *            List<Integer> list store data related to their sides
	 */
	public void addShape(shapeType type, Point point, List<Integer> list)
			throws CloneNotSupportedException {
		if (point.getX() > 0 && point.getX() < screenEndPoint.getX()
				&& point.getY() > 0 && point.getY() < screenEndPoint.getY()) {
			if (pointHasShape(point) != null) {
				System.out
						.println("A shape is already drawn at this origin point.");
			} else {
				Shape tempShape = new ShapeFactory().getInstance(type, point,
						list);
				shapes.add(tempShape);
			}
		} else {
			System.out.println("Point lies outside the screen.");
		}

	}

	/**
	 * Method to delete a specific shape.
	 * 
	 * @param originPoint
	 *            of the shape
	 */
	public void deleteShape(Point originPoint)
			throws CloneNotSupportedException {
		Shape foundshape = pointHasShape(originPoint);
		if (foundshape != null) {
			shapes.remove(foundshape);
		} else {
			System.out.println("Not Found!!");
		}

	}

	/**
	 * Method to delete a specific type shapes.
	 * 
	 * @param type
	 *            of the shape
	 */
	public void deleteSpecificTypeShapes(shapeType type) {
		List<Shape> newShapes = new ArrayList<Shape>();

		for (Shape shape : shapes) {
			if (shape.getType() != type) {
				newShapes.add(shape);
			}

		}
		shapes = newShapes;

	}

	/**
	 * Method to check if a shape is already present on the point.
	 * 
	 * @param passedPoint
	 *            a point where we have to check
	 */
	public Shape pointHasShape(Point passedPoint)
			throws CloneNotSupportedException {
		for (Shape shape : shapes) {
			if (shape.getOrigin().isEqual(passedPoint)) {
				return shape;
			}
		}

		return null;
	}

	/**
	 * Method to give list of shapes that have the point inside them.
	 * 
	 * @param passedPoint
	 *            point to check
	 * 
	 * @return List of shape type object, having passedPoint inside them
	 */
	public List<Shape> isPointOccupied(Point passedPoint)
			throws CloneNotSupportedException {
		List<Shape> resultedList = new ArrayList<Shape>();
		for (Shape shape : shapes) {
			if (isPointInShape(shape.getOrigin(), shape.getList(),
					shape.getType(), passedPoint)) {
				resultedList.add(shape);
			}
		}

		return resultedList;
	}

	/**
	 * Support Method to check the point is inside the shape or not.
	 * 
	 * @param originPoint
	 *            of the shape, list of shape data, shapeType type of shape
	 *            passPoint point to check
	 * 
	 * @return true if passPoint is inside the shape otherwise false
	 */
	private boolean isPointInShape(Point originPoint, List<Integer> data,
			shapeType type, Point passPoint) {

		switch (type) {
		case CIRCLE:
			if (Math.pow((passPoint.getX() - originPoint.getX()), 2)
					+ Math.pow((passPoint.getY() - originPoint.getY()), 2) < Math
						.pow(data.get(0), 2)) {
				return true;
			}
			break;
		case RECTANGLE:
		case SQUARE:
			if (passPoint.getX() > originPoint.getX()
					&& passPoint.getX() < (originPoint.getX() + data.get(0))
					&& passPoint.getY() > originPoint.getY()
					&& passPoint.getY() < (originPoint.getY() + data.get(1))) {
				return true;
			}
			break;
		}

		return false;

	}

	/**
	 * Support Method to make clone of list of shapes present on the screen.
	 * 
	 * @return cloned list
	 */
	private List<Shape> getClone() {
		List<Shape> newShapes = new ArrayList<Shape>();
		for (Shape shape : shapes) {
			newShapes.add(shape);
		}
		return newShapes;
	}

	/**
	 * Method to sort shapes list on the basis of area in ascending order.
	 * 
	 * @return sorted listed
	 */
	public void sortOnArea() throws CloneNotSupportedException {
		List<Shape> newShapes = getClone();
		Collections.sort(newShapes, new sortByArea());
		for (Shape shape : newShapes) {
			shape.display();
		}
	}

	/**
	 * Method to sort shapes list on the basis of perimeter in ascending order.
	 * 
	 * @return sorted listed
	 */
	public void sortOnPerimeter() throws CloneNotSupportedException {
		List<Shape> newShapes = getClone();
		Collections.sort(newShapes, new sortByPerimeter());
		for (Shape shape : newShapes) {
			shape.display();
		}
	}

	/**
	 * Method to sort shapes list on the basis of distance from the origin in
	 * ascending order.
	 * 
	 * @return sorted listed
	 */
	public void sortOnOrigin() throws CloneNotSupportedException {
		List<Shape> newShapes = getClone();
		Collections.sort(newShapes, new sortByOrigin());
		for (Shape shape : newShapes) {
			shape.display();
		}
	}

	/**
	 * Method to display shapes on the screen.
	 */
	public void display() throws CloneNotSupportedException {
		for (Shape shape : shapes) {
			shape.display();
		}
	}
}
