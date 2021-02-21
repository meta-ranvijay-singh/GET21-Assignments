package Question2;

import java.util.*;
public class FCFS{
	int p[][],ct[],tat[],wt[],size;
	public FCFS(int pro[][], int n){
		p=pro;
		size=n;
		ct=new int[n];
		tat=new int[n];
		wt=new int[n];
	}
	public void completionTime(){
		ct[0]=p[0][1];
		for(int i=1; i<size; i++){
			ct[i]=ct[i-1]+ p[i][1];
		}
	}
	public void averageWaitingTime(){
		int sum=0;
		for(int i=0; i<wt.length; ++i){
			sum+=wt[i];
		}

double avg=(double)sum/wt.length;
		System.out.println("Average waiting time : "+avg );
	}
	public void maxWaitingTime(){
		int max=wt[0];
		for(int i=1; i<wt.length; ++i){
			if(max<wt[i]){
				max=wt[i];
			}
		}
		System.out.println("Maximum waiting time in queue : "+max);
	}
	public void waitingTime(){

		for(int i=0; i<size; i++){
			wt[i]=tat[i]-p[i][1];
		}
	}
	public void turnAroundTime(){
		for(int i=0; i<size; ++i){
			tat[i]=ct[i]-p[i][0];
		}
	}
	public void display(){
		System.out.printf("%20s %20s %20s %20s %20s %20s \n","Process","Arrival Time","Brust Time","Completion Time",
				"TurnAround Time","Waiting Time");
		for(int i=0; i<size; i++){
			//System.out.println(ct[i]);
			System.out.printf("%20s %20d %20d %20d %20d %20d \n","P"+(i+1),p[i][0],p[i][1],ct[i],
					tat[i],wt[i]);
			
		}
		averageWaitingTime();
		maxWaitingTime();
	}
}

