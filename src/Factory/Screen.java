package Factory;

import java.util.ArrayList;
import java.util.List;

import Factory.Shape.shapeType;

public class Screen {
	private Point screenEndPoint;
	List<Shape> shapes;
	
	public Screen(Point point) throws CloneNotSupportedException {
		// TODO Auto-generated constructor stub
		shapes=new ArrayList<Shape>();
		screenEndPoint=(Point)point.clone();
	}
	
	public void addShape(shapeType type, Point point, List<Integer> list) throws CloneNotSupportedException{
		Shape tempShape=new ShapeFactory().getInstance(type, point, list);
		shapes.add(tempShape);
	}
}
