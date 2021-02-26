package Problem2;

import java.util.Scanner;

import Problem1.intSet;

public class Main {

	public static void menu(){
		System.out.println();
		System.out.println("-------MENU-------");
		System.out.println("1. Evaluate.");
		System.out.println("2. Find degree");
		System.out.println("3. Add polynomial");
		System.out.println("4. Multiply polynomial");
		System.out.println("5. Exit");
		System.out.println("Enter choice : ");
	}
	
	public static int[][] input(){
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the no. of terms : ");
		int term=in.nextInt();
		int[][] poly=new int[term][2];
		System.out.print("Enter coefficient and power respt. : ");
		for(int i=0; i<term; ++i){
			poly[i][0]=in.nextInt();
			poly[i][1]=in.nextInt();
		}
		return poly;
	}
	
	public static void main(String[] args) {
		int ch,poly1[][],poly2[][];
		Scanner in=new Scanner(System.in);
		Poly p1,p2,p3;
				
		do{
			menu();
			ch=in.nextInt();
			switch(ch){
			case 1: 
				poly1=input();
				p1=new Poly(poly1);
				System.out.print("Enter the value : ");
				float val=in.nextFloat();
				p1.display();
				System.out.print("\nResult : "+p1.evaluate(val));
				
				break;
			
			case 2: 
				poly1=input();
				p1=new Poly(poly1);
				p1.display();
				System.out.print("\nDegree : "+p1.degree());
				break;
			
			case 3: 
				poly1=input();
				poly2=input();
				p1=new Poly(poly1);
				p2=new Poly(poly2);
				p3=p1.addPoly(p1, p2);
				System.out.print("Result : ");
				System.out.print(" ( ");
				p1.display();
				System.out.print(" ) ");
				System.out.print(" + ");
				System.out.print(" ( ");
				p2.display();
				System.out.print(" ) ");
				System.out.print(" = ");
				p3.display();
				break;
				
			case 4: 
				poly1=input();
				poly2=input();
				p1=new Poly(poly1);
				p2=new Poly(poly2);
				
				p3=p1.multiplyPoly(p1, p2);
				System.out.print("Result : ");
				System.out.print(" ( ");
				p1.display();
				System.out.print(" ) ");
				System.out.print(" * ");
				System.out.print(" ( ");
				p2.display();
				System.out.print(" ) ");
				System.out.print(" = ");
				p3.display();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				break;
			}
		}while(ch != 0);
		
	}

}
