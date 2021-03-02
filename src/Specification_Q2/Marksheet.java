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
		avg=sum/no_of_stud;
		
		return avg;
	}
	
	/**
	 * Find maximum grade.
	 * @return int max maximum of all grades
	 */
	public int maxGrade(){
		int max=0;
		for(int marks:grade){
			if(max < marks){
				max=marks;
			}
		}
		return max;
	}

	/**
	 * Find minimum grades.
	 * @return int min maximum of all grades
	 */
	public int minGrade(){
		int min=grade.get(0);
		
		for(int i=1; i<grade.size(); ++i){
			if(min > grade.get(i)){
				min=grade.get(i);
			}
		}
		
		return min;
	}
	
	/**
	 * Find percentage of passed students.
	 * @return float percent percentage of passed student
	 */
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
