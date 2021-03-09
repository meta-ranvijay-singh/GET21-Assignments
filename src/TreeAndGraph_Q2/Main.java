package TreeAndGraph_Q2;

import java.util.Scanner;

public class Main {

	public static void menu(){
		System.out.println("\n--------Menu-----------");
		System.out.println("1. Enqueue");
		System.out.println("2. Dequeue");
		System.out.println("3. Peek");
		System.out.println("4. Display");
		System.out.println("0. Exit");
		System.out.println("Enter :");
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		System.out.print("Enter Size of the queue :");
		int size=in.nextInt();
		
		Priority_Queue priority_Queue=new Priority_Queue(size);
		
		int choice, priority, value;
		
		do{
			menu();
			choice=in.nextInt();
			switch(choice){
			case 1:
				System.out.print("Enter priority :");
				priority=in.nextInt();
				
				System.out.print("Enter value :");
				value=in.nextInt();
				
				if(priority_Queue.Enqueue(value, priority)){
					System.out.println("Added successfully.");
				}
				else{
					System.out.println("Error.");
				}
				break;
			case 2:
				if(priority_Queue.Dequeue()){
					System.out.println("Element Deleted successfully");
				}
				else{
					System.out.println("Error.");
				}
				break;
			case 3:
				System.out.println("Peek value : "+ priority_Queue.peek());
				break;
			case 4:
				System.out.println("Elements in priority queue :");
				priority_Queue.Display();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("INVALID");
				break;
			}
			
		}while(choice != 0);
	}

}
