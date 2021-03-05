package Factory;

/**
 * Class for storing point
 */
public class Point implements Cloneable {
	private double point_x, point_y;

	/**
	 * Constructor for initializing point_x and point_y
	 * 
	 * @param double x and y
	 */
	public Point(double x, double y) {
		point_x = x;
		point_y = y;
	}

	/**
	 * Method to get x-coordinate
	 * 
	 * @return point_x the x-coordinate of the point
	 */
	public double getX() {
		return point_x;
	}

	/**
	 * Method to get y-coordinate
	 * 
	 * @return point_y the y-coordinate of the point
	 */
	public double getY() {
		return point_y;
	}

	/**
	 * Method to check the passed point is equal or not
	 * 
	 * @param passedPoint
	 *            to check for equality
	 * @return true for equal otherwise false
	 */
	public boolean isEqual(Point passedPoint) {
		if (point_x == passedPoint.getX()) {
			if (point_y == passedPoint.getY()) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Method to make clone of Point class object
	 * 
	 * @return a cloned object
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/**
	 * Method to print details of Point class object
	 * 
	 * @return String to be print
	 */
	public String toString() {
		return "(x,y) : (" + point_x + ", " + point_y + ")";
	}
}
