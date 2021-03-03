package Factory;

import java.util.List;

import Factory.Shape.shapeType;

public class ShapeFactory {
	public Shape getInstance(shapeType type, Point point, List<Integer> list) throws CloneNotSupportedException{
		
		switch(type){
		case CIRCLE:
				return new Circle(point,list.get(0));

		case TRIANGLE:
			break;
		case RECTANGLE:
			break;
		case SQUARE:
			break;
		default:
			return null;
		}
		return null;
	}
}
