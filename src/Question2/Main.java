package Question2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int pro[][]=new int[100][2];
	Scanner in=new Scanner(System.in);
	System.out.println("Enter no. of process : ");
	int n=in.nextInt();
	System.out.println("Enter arrival time and brust time respectively : ");
	for(int i=0; i<n; ++i){
		for(int j=0; j<2; ++j){
			pro[i][j]=in.nextInt();
		}
	}
	FCFS f=new FCFS(pro,n);

	f.completionTime();
	f.turnAroundTime();
	f.waitingTime();
	f.display();
	
}


	}
