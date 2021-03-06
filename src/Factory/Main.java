package Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Factory.Shape.shapeType;

public class Main {
	static Scanner in = new Scanner(System.in);

	/**
	 * Method to display main menu.
	 */
	public static void mainMenu() {
		System.out.println("\n--------Main Menu---------");
		System.out.println("1. Add shape");
		System.out.println("2. Delete shape");
		System.out.println("3. Delete shapes of specific type");
		System.out.println("4. Check point in shapes");
		System.out.println("5. Sort By Area");
		System.out.println("6. Sort By Perimeter");
		System.out.println("7. Sort By Origin distance");
		System.out.println("8. Sort By Time Stamp");
		System.out.println("0. Exit");
		System.out.print("Enter your choice :");
	}

	/**
	 * Method to display shape type menu.
	 */
	public static void shapeTypeMenu() {
		System.out.println("\n--------Shape Type---------");
		System.out.println("1. Circle");
		System.out.println("2. Rectangle");
		System.out.println("3. Square");
		System.out.println("4. Triangle");
		System.out.println("5. Regular Polygon (sides > 4) ");
		System.out.println("0. Exit");
		System.out.print("Enter your choice :");
	}

	/**
	 * Method to get input for origin point.
	 * 
	 * @return origin point
	 */
	public static Point inputOrigin() {
		System.out.println("Enter (x , y) :");
		double x = in.nextDouble();
		double y = in.nextDouble();

		Point origin = new Point(x, y);
		return origin;

	}

	/**
	 * Main method.
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Screen screen;
		Point originPoint;
		Shape shape;
		int choice,side=3;
		double x_max, y_max;
		List<Integer> list;
		List<Point> sidePoints;
		shapeType type_of_shape;

		System.out.print("Enter X_MAX of the screen : ");
		x_max = in.nextDouble();

		System.out.print("Enter Y_MAX of the screen : ");
		y_max = in.nextDouble();

		screen = new Screen(new Point(x_max, y_max));
		do {
			mainMenu();
			choice = in.nextInt();
			/**
			 * Switch case for Main menu
			 */
			switch (choice) {
			case 1:
				shapeTypeMenu();
				choice = in.nextInt();

				/**
				 * Switch case for shape type
				 */
				switch (choice) {
				case 1:
					System.out.print("Enter Origin Point :");
					originPoint = inputOrigin();
					list = new ArrayList<Integer>();
					System.out.print("Enter radius :");
					list.add(in.nextInt());
					screen.addShape(shapeType.CIRCLE, originPoint, list, null);
					screen.display();
					System.out.print("");
					break;
				case 2:
					System.out.print("Enter Left Bottom point :");
					originPoint = inputOrigin();
					list = new ArrayList<Integer>();

					System.out.print("Enter length :");
					list.add(in.nextInt());

					System.out.print("Enter width :");
					list.add(in.nextInt());

					screen.addShape(shapeType.RECTANGLE, originPoint, list, null);
					screen.display();
					break;
				case 3:
					System.out.print("Enter Left Bottom point :");
					originPoint = inputOrigin();
					list = new ArrayList<Integer>();

					System.out.print("Enter side :");
					list.add(in.nextInt());

					screen.addShape(shapeType.SQUARE, originPoint, list, null);
					screen.display();
					break;
				case 4:
					System.out.print("Enter Left Bottom point :");
					originPoint = inputOrigin();
					sidePoints=new ArrayList<Point>();
					list = new ArrayList<Integer>();

					for(int i=0; i < side; ++i){
						System.out.print("Enter length of side "+(i+1) +" :");
						list.add(in.nextInt());
					}
					
					for(int i=1; i < side; ++i){
						System.out.print("Enter coordinate of point "+ (i+1) +" :");
						sidePoints.add(inputOrigin());
					}

					screen.addShape(shapeType.TRIANGLE, originPoint, list, sidePoints);
					screen.display();
					break;
				case 5:

					System.out.print("Enter no. of side :");
					int no_of_side=in.nextInt();
					
					if(no_of_side <= 4){
						System.out.println("Enter no of sides greater than 4.");
					}
					else{
						System.out.print("Enter Left Bottom point :");
						originPoint = inputOrigin();
						sidePoints=new ArrayList<Point>();
						list = new ArrayList<Integer>();
						
						for(int i=0; i < no_of_side; ++i){
							System.out.print("Enter length of side "+(i+1) +" :");
							list.add(in.nextInt());
						}
						
						for(int i=1; i < no_of_side; ++i){
							System.out.print("Enter coordinate of point "+ (i+1) +" :");
							sidePoints.add(inputOrigin());
						}

						screen.addShape(shapeType.REGULAR_POLYGON, originPoint, list, sidePoints);
						screen.display();
					}
					break;
				case 0:
					System.exit(0);
					break;
				default:
					System.out.println("INVALID inputs");
					break;
				}
				break;
			case 2:
				originPoint = inputOrigin();
				screen.deleteShape(originPoint);
				screen.display();
				System.out.print("");
				break;
			case 3:
				shapeTypeMenu();
				choice = in.nextInt();

				/**
				 * Switch case for shape type
				 */
				switch (choice) {
				case 1:
					screen.deleteSpecificTypeShapes(shapeType.values()[choice - 1]);
					screen.display();
					break;
				case 2:
					screen.deleteSpecificTypeShapes(shapeType.values()[choice - 1]);
					screen.display();
					break;
				case 3:
					screen.deleteSpecificTypeShapes(shapeType.values()[choice - 1]);
					screen.display();
					break;
				case 4:
					screen.deleteSpecificTypeShapes(shapeType.values()[choice - 1]);
					screen.display();
					break;
				case 0:
					System.exit(0);
					break;
				default:
					System.out.println("INVALID inputs");
					break;
				}

				break;
			case 4:
				Point point = inputOrigin();
				List<Shape> hasPointList = screen.isPointOccupied(point);

				for (Shape shapeList : hasPointList) {
					shapeList.display();
				}

				break;
			case 5:
				screen.sortOnArea();
				break;
			case 6:
				screen.sortOnPerimeter();
				break;
			case 7:
				screen.sortOnOrigin();
				break;
			case 8:
				screen.display();
				break;
			case 0:
				System.exit(0);
				break;

			default:
				System.out.println("INVALID choice.");
				break;

			}
		} while (choice != 0);
	}

}
