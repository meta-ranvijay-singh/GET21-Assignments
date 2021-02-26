package Specification_Q3;

public class Area {

	public double triangleArea(double width, double height){
		return 0.5 * width * height;
	}
	
	public double rectangleArea(double width, double height){
		return width * height;
	}
	
	public double circleArea(double radius){
		return 3.14 * radius * radius;
	}
	
	public double squareArea(double width){
		return width * width;
	}
}
