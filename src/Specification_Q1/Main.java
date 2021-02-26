package Specification_Q1;

import java.util.Scanner;

public class Main {
	static Scanner in=new Scanner(System.in);
	public static void menu(){
		System.out.println("\n---------MENU----------");
		System.out.println("1. Compare two strings.");
		System.out.println("2. Reverse string.");
		System.out.println("3. Flip case of the string.");
		System.out.println("4. Find largest word of the string.");
		System.out.println("0. Exit");
		System.out.print("Enter choice :");
	}
	
	public static String input(){
		Scanner i=new Scanner(System.in);
		System.out.println("Enter string :");
		String str=i.nextLine();
		return str;
	}

	public static void main(String[] args) {
		
		stringOperation str=new stringOperation();
		int ch;
		String str1,str2;
		
		do{
			menu();
			ch=in.nextInt();
			switch(ch){
			case 1:
				str1=input();

				str2=input();

				System.out.println("Result :"+str.compareStrings(str1, str2));
				break;
			case 2:
				str1=input();
				System.out.println("Reversed string :"+str.reverseString(str1));
				break;
			case 3:
				str1=input();
				System.out.println("Result : "+str.reverseCase(str1));
				break;
			case 4:
				str1=input();
				System.out.println("Longest word : "+str.largestWord(str1));
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("INVALID input.");
				break;
			}
		}while(ch != 0);
		
		System.out.println(str.largestWord("To find the number of letters in longest word of string, you can do"));
		
		

	}

}
