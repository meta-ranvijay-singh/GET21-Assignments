package Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Factory.Shape.shapeType;

public class Main {
	static Scanner in=new Scanner(System.in);
	
	public static void mainMenu(){
		System.out.println("\n--------Main Menu---------");
		System.out.println("1. Add shape");
		System.out.println("2. Delete shape");
		System.out.println("3. Delete shapes of specific type");
		System.out.println("4. Check point in shapes");
		System.out.println("0. Exit");
		System.out.print("Enter your choice :");
	}
	
	public static void shapeTypeMenu(){
		System.out.println("\n--------Shape Type---------");
		System.out.println("1. Circle");
		System.out.println("2. Rectangle");
		System.out.println("3. Square");
		System.out.println("4. Triangle");
		System.out.println("0. Exit");
		System.out.print("Enter your choice :");
	}
	
	public static Point inputOrigin(){
		System.out.println("Enter (x , y) :");
		double x=in.nextDouble();
		double y=in.nextDouble();
		
		Point origin=new Point(x, y);
		return origin;
		
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Screen screen;
		Point originPoint;
		Shape shape;
		int choice;
		double  x_max, y_max;
		List<Integer> list;
		shapeType type_of_shape;
		
		System.out.print("Enter X_MAX of the screen : ");
		x_max=in.nextDouble();
		
		System.out.print("Enter Y_MAX of the screen : ");
		y_max=in.nextDouble();
		
		screen=new Screen(new Point(x_max,y_max));
		do{
			mainMenu();
			choice=in.nextInt();
			
			switch(choice){
			case 1:
				shapeTypeMenu();
				choice=in.nextInt();
				switch(choice){
				case 1:
					System.out.print("Enter Origin Point :");
					originPoint=inputOrigin();
					list=new ArrayList<Integer>();
					System.out.print("Enter radius :");
					list.add(in.nextInt());
					shape=new ShapeFactory().getInstance(shapeType.CIRCLE, originPoint, list);
					screen.addShape(shapeType.CIRCLE, originPoint, list);
					screen.display();
					System.out.print("");
					break;
				case 2:
					System.out.print("Enter Left Bottom point :");
					originPoint=inputOrigin();
					list=new ArrayList<Integer>();
					
					System.out.print("Enter length :");
					list.add(in.nextInt());
					
					System.out.print("Enter width :");
					list.add(in.nextInt());
					
					shape=new ShapeFactory().getInstance(shapeType.RECTANGLE, originPoint, list);
					screen.addShape(shapeType.RECTANGLE, originPoint, list);
					screen.display();
					break;
				case 3:
					System.out.print("Enter Left Bottom point :");
					originPoint=inputOrigin();
					list=new ArrayList<Integer>();
					
					System.out.print("Enter side :");
					list.add(in.nextInt());
					
					shape=new ShapeFactory().getInstance(shapeType.SQUARE, originPoint, list);
					screen.addShape(shapeType.SQUARE, originPoint, list);
					screen.display();
					break;
				case 4:
					System.out.print("Enter Left Bottom point :");
					originPoint=inputOrigin();
					list=new ArrayList<Integer>();
					
					System.out.print("Enter length of side 1 :");
					list.add(in.nextInt());
					
					System.out.print("Enter length of side 2 :");
					list.add(in.nextInt());
					
					System.out.print("Enter length of side 3 :");
					list.add(in.nextInt());
					
					shape=new ShapeFactory().getInstance(shapeType.TRIANGLE, originPoint, list);
					screen.addShape(shapeType.TRIANGLE, originPoint, list);
					screen.display();
					break;
				case 0:	System.exit(0);
					break;
				default: System.out.println("INVALID inputs");
				break;
				}
				break;
			case 2:
				originPoint=inputOrigin();
				screen.deleteShape(originPoint);
				screen.display();
				System.out.print("");
				break;
			case 3:
				shapeTypeMenu();
				choice=in.nextInt();
				switch(choice){
				case 1:
					screen.deleteSpecificTypeShapes(shapeType.values()[choice-1]);
					screen.display();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 0:	System.exit(0);
					break;
				default: System.out.println("INVALID inputs");
				break;
				}
				
				break;
			case 4:
				Point point=inputOrigin();
				List<Shape> hasPointList=screen.isPointOccupied(point);
				
				for(Shape shapeList:hasPointList ){
					shapeList.display();
				}
				
				break;
			case 0:	System.exit(0);
				break;
				
			default:System.out.println("INVALID choice.");
				break;
			
			}
		}while(choice != 0);
	}

}
