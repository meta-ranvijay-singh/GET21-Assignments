package Specification_Q3;

import java.util.Scanner;

public class Main {
	
	public static void menu(){
		System.out.println("\n---------MENU----------");
		System.out.println("1. Find area of triangle.");
		System.out.println("2. Find area of rectangle.");
		System.out.println("3. Find area of square.");
		System.out.println("4. Find area of circle.");
		System.out.println("0. Exit");
		System.out.print("Enter choice :");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int ch;
		Area area=new Area();
		double width,height,radius,side;
		
		do{
			menu();
			ch=in.nextInt();
			switch(ch){
			case 1:
				System.out.println("Enter width : ");
				width=in.nextDouble();
				System.out.println("Enter height : ");
				height=in.nextDouble();
				System.out.printf("Area : %.2f",area.triangleArea(width, height));
				break;
			case 2:
				System.out.println("Enter width : ");
				width=in.nextDouble();
				System.out.println("Enter height : ");
				height=in.nextDouble();
				System.out.printf("Area : %.2f",area.rectangleArea(width, height));
				break;
			case 3:
				System.out.println("Enter side : ");
				side=in.nextDouble();
				System.out.printf("Area : %.2f",area.squareArea(side));
				break;
			case 4:
				System.out.println("Enter radius : ");
				radius=in.nextDouble();
				System.out.printf("Area : %.2f",area.circleArea(radius));
				break;
			case 0:
				System.exit(0);
				
			default:
				System.out.println("INVALID input.");
				break;
			}
		}while(ch != 0);

	}

}
