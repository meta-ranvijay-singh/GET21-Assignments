package Factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Factory.Shape.shapeType;

public class RegularPoly implements Shape{
	private double area, perimeter;
	private Date date;
	private Point originPoint;
	private shapeType type;
	private List<Integer> list;
	private List<Point> sidePoints;

	/**
	 * Triangle constructor initializing its data member.
	 * @param shapeType type store type of shape, Point point origin point,
	 * List<Integer> list store its three side
	 */
	public RegularPoly(shapeType type, Point point, List<Integer> list, List<Point> sidePoints)
			throws CloneNotSupportedException {
		originPoint = (Point) point.clone();
		this.type = type;
		this.sidePoints=sidePoints;
		date = Calendar.getInstance().getTime();
		this.list = list;
		this.sidePoints.add(originPoint);

		double apothem= list.get(0) / ( 2* Math.tan( 180 / list.size() ) );
		
		perimeter=calculate_Perimeter();
		
		area = ( apothem * perimeter ) / 2;

	}
	
	private double calculate_Perimeter(){
		double sum=0.0;
		for(int side:list){
			sum+=side;
		}
		return sum;
	}
	

	/**
	 * Method to return area triangle.
	 * @return area of triangle
	 */
	@Override
	public double getArea() {
		return area;
	}

	/**
	 * Method to origin point of triangle.
	 * @return origin point of triangle
	 */
	@Override
	public Point getOrigin() throws CloneNotSupportedException {
		return (Point) originPoint.clone();
	}

	/**
	 * Method to get perimeter of triangle.
	 * @return perimeter of triangle
	 */
	@Override
	public double getPerimeter() {
		return perimeter;
	}

	/**
	 * Method to check if point is inside the triangle.
	 * @return true if point is inside the triangle otherwise else
	 */
	@Override
	public boolean isPointEnclosed(Point passedPoint) {

		    boolean c = false;
		    int i, j;
		    for (i = 0, j = list.size()-1; i < list.size(); j = i++) {
		      if ( ((sidePoints.get(i).getY() >passedPoint.getY()) != (sidePoints.get(j).getY()>passedPoint.getY())) &&
		  	 (passedPoint.getX() < (sidePoints.get(j).getX()-sidePoints.get(i).getX()) * (passedPoint.getY()-sidePoints.get(i).getY()) / (sidePoints.get(j).getY()-sidePoints.get(i).getY()) + sidePoints.get(i).getX()) )
		         c = !c;
		    }
	    	System.out.println(c);
		    return c;	
		    
	}
	

	/**
	 * Method to get type of shape.
	 * @return type of shape
	 */
	@Override
	public shapeType getType() {
		return type;
	}

	/**
	 * Method to get sides of triangle.
	 * @return tempList sides of triangle.
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
	 * Method to display triangle properties.
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
