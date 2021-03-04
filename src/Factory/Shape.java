package Factory;

import java.util.List;

public interface Shape{
	enum shapeType{
		CIRCLE,RECTANGLE,SQUARE,TRIANGLE
	};
	
	double getArea();
	Point getOrigin() throws CloneNotSupportedException;
	double getPerimeter();
	boolean isPointEnclosed(Point p);
	shapeType getType();
	List<Integer> getList();
	void display();
}
