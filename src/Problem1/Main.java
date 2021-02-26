package Problem1;

import java.util.Scanner;

public class Main {
	public static void menu(){
		System.out.println();
		System.out.println("-------MENU-------");
		System.out.println("1. To check member.");
		System.out.println("2. To check Size");
		System.out.println("3. To check subSet");
		System.out.println("4. Get complement");
		System.out.println("5. Union");
		System.out.println("6. Exit");
		System.out.println("Enter choice : ");
	}
	
	public static int[] inputArray(){
		Scanner in=new Scanner(System.in);
		int size;
		System.out.println("Enter the size of the set : ");
		size=in.nextInt();
		int arr[]=new int[size];
		System.out.println("Enter elements of the set : ");
		for(int i=0; i<size; ++i){
			arr[i]=in.nextInt();
		}
		return arr;
	}
	public static void display(int[] a){
		for(int i=0; i<a.length; ++i){
			System.out.print(a[i]+" ");
		}
	}
	public static void main(String[] args) {
		
		int ch;
		Scanner in=new Scanner(System.in);
		intSet set1,set2;
		
		set1=new intSet(inputArray());
		
		do{
			menu();
			ch=in.nextInt();
			switch(ch){
			case 1: 
				
				System.out.print("Enter the number to check member: ");
				int num=in.nextInt();
				if(set1.isMember(num)){
					System.out.println(num +" is the member of the set.");
				}
				else{
					System.out.println(num +" is not the member of the set.");
				}
				break;
			
			case 2: 
				//set1=new intSet(inputArray());
				System.out.println("Size of the set : "+set1.size());
				break;
			
			case 3: System.out.println("Enter the details of  setB to check for sub set: ");
				set2=new intSet(inputArray());
				
				if(set1.isSubSet(set2)){
					System.out.println("SetB is the sub set of the setA.");
				}
				else{
					System.out.println("SetB is not the sub set of the setA.");
				}
				break;
				
			case 4: 
				//set1=new intSet(inputArray());
				int a[]=set1.getComplement();
				System.out.println("Complement set : ");
				display(a);
				
				break;
			case 5: System.out.println("Enter setA : ");
				set1=new intSet(inputArray());
		
				System.out.println("Enter setB : ");
				set2=new intSet(inputArray());
				
				int ar[]=set1.union(set1, set2);
				display(ar);
				break;	
			case 6:
				System.exit(0);
				break;
			default:
				break;
			}
		}while(ch != 0);

	}

}
