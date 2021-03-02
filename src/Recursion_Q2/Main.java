package Recursion_Q2;

import java.util.Scanner;

public class Main {

	static Scanner in=new Scanner(System.in);
	
	/**
	 * Menu of the program
	 */
	public static void menu(){
		System.out.println("\n----------MENU---------");
		System.out.println("1. Find value using Linear Search");
		System.out.println("2. Find value using Binary Search");
		System.out.println("0. Exit");
		System.out.println("Enter your choice");
	}
	
	/**
	 * Method to take input from user
	 * @return num number entered by user
	 */
	public static int input(){
		System.out.println("Enter value to search :");
		int num=in.nextInt();
		
		return num;
	}
	public static void main(String[] args) {
		
		int arr[],ch,val;
		
		Search search=new Search();
		
		System.out.println("Enter no. of element :");
		int num=in.nextInt();
		System.out.println("Enter elements :");
		arr=new int[num];
		
		for(int i=0; i<num; ++i){
			arr[i]=in.nextInt();
		}
		
		do{
			menu();
			ch=in.nextInt();
			switch(ch){
			case 1:
				val=input();
				System.out.println("Index : "+search.LinearSearch(arr, val));
				break;
			case 2:
				val=input();
				System.out.println("Index : "+search.BinarySearch(arr, val));
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("INVALID input.");
				break;
			}
		}while(ch != 0);
		
		System.out.println(search.BinarySearch(arr, 11));
		
	}

}
