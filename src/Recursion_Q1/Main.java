package Recursion_Q1;

import java.util.Scanner;

public class Main {

	static Scanner in=new Scanner(System.in);
	
	/**
	 * Menu of the program
	 */
	public static void menu(){
		System.out.println("\n----------MENU---------");
		System.out.println("1. Find LCM");
		System.out.println("2. Find HCF");
		System.out.println("0. Exit");
		System.out.println("Enter your choice");
	}
	
	/**
	 * Method to take inputs from user
	 * @return array of two numbers
	 */
	public static int[] inputArray(){
		int arr[]=new int[2];
		System.out.println("Enter two numbers :");
	
		for(int i=0; i<2; ++i){
			arr[i]=in.nextInt();
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		
		int arr[],ch;
		
		Mathematics math=new Mathematics();
		
		do{
			menu();
			ch=in.nextInt();
			switch(ch){
			case 1:
				arr=inputArray();
				System.out.println("LCM : "+math.findLCM(arr[0], arr[1]));
				break;
			case 2:
				arr=inputArray();
				System.out.println("HCF : "+math.findHCF(arr[0], arr[1]));
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
