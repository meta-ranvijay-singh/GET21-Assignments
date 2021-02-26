package Specification_Q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void menu(){
		System.out.println("\n---------MENU----------");
		System.out.println("1. Find average grade.");
		System.out.println("2. Find maximum grade.");
		System.out.println("3. Find minimum grade.");
		System.out.println("4. Find percentage of passed student.");
		System.out.println("0. Exit");
		System.out.print("Enter choice :");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		List<Integer> gradeList=new ArrayList<Integer>();
		int ch;
		
		System.out.print("Enter no. of student : ");
		int num=in.nextInt();
		for(int i=0; i<num; ++i){
			System.out.print("Enter grade of student "+ (i+1) +" : ");
			int mark=in.nextInt();
			gradeList.add(mark);
		}
		
		Marksheet markList=new Marksheet(num, gradeList);
		
		do{
			menu();
			ch=in.nextInt();
			switch(ch){
			case 1:
				System.out.printf("Average grade : %.2f",markList.average());
				break;
			case 2:
				System.out.println("Maximum grade : "+markList.maxGrade());
				break;
			case 3:
				System.out.println("Minimum grade : "+markList.minGrade());
				break;
			case 4:
				System.out.printf("Passed percentage : %.2f",markList.passPercentage());
				break;
			case 0:
				System.exit(0);
				break;
			default:
				break;
			}
		}while(ch != 0);
		

	}

}
