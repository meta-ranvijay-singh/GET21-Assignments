package Specification_Q2;

import java.util.List;

public class Marksheet {
	private List<Integer> grade;
	int no_of_stud;
	
	Marksheet(int num, List<Integer> gradeList){
		grade=gradeList;
		no_of_stud=num;
	}
	
	/**
	 * Find average of all grades.
	 * @return float avg average of all grades
	 */
	public float average() throws ArithmeticException{
		float avg;
		int sum=0;
		for(int marks:grade){
			sum+=marks;
		}
		avg=sum/0;
		
		return avg;
	}
	
	public int maxGrade(){
		int max=0;
		for(int marks:grade){
			if(max < marks){
				max=marks;
			}
		}
		return max;
	}
	
	public int minGrade(){
		int min=grade.get(0);
		
		for(int i=1; i<grade.size(); ++i){
			if(min > grade.get(i)){
				min=grade.get(i);
			}
		}
		
		return min;
	}
	
	public float passPercentage(){
		float percent;
		int count=0;
		for(int marks:grade){
			if(marks >= 40){
				++count;
			}
		}
		
		float temp=(float)count/no_of_stud;
		percent= temp * 100 ;
		return percent;
	}
	
}
