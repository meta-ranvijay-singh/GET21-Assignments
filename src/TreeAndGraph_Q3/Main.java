package TreeAndGraph_Q3;

import java.util.Scanner;


public class Main {

	
	public static void main(String[] arg) {
		Scanner in=new Scanner(System.in);
		
		System.out.print("Enter number of bowler :");
		int no_of_bowler=in.nextInt();
		
		MaxHeap maxHeap = new MaxHeap(no_of_bowler);
		
		for(int i=1; i<=no_of_bowler; ++i){
			System.out.print("Enter no. of bowl left of bowler "+i+" :");
			int bowl=in.nextInt();
			maxHeap.insert(bowl);
		}
		
		System.out.println("The order of bowling acc. to their bowl left :");
		
		while(!maxHeap.isEmpty())
		System.out.println("The bowler having bowl left :" + maxHeap.removeMaxHeap());
		
	}
}
