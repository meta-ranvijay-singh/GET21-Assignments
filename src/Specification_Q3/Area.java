package Specification_Q3;

public class Area {
	private final double PI=3.14;
	private final double half=0.5;
	/**
	 * Find area of triangle.
	 * @param double width and height of triangle
	 * @return double area of triangle
	 */
	public double triangleArea(double width, double height){
		return half * width * height;
	}
	
	/**
	 * Find area of rectangle.
	 * @param double width and height of rectangle
	 * @return double area of rectangle
	 */
	public double rectangleArea(double width, double height){
		return width * height;
	}

	/**
	 * Find area of circle.
	 * @param double radius of circle
	 * @return double area of circle
	 */
	public double circleArea(double radius){
		return PI * radius * radius;
	}
	
	/**
	 * Find area of square.
	 * @param double side of square
	 * @return double area of square
	 */
	public double squareArea(double width){
		return width * width;
	}
}
