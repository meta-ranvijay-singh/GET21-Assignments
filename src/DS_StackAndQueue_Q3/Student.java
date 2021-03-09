package DS_StackAndQueue_Q3;

import java.util.ArrayList;
import java.util.List;

/*
 * Class to store Student details
 */
public class Student {
	private String student_name;
	private List<String> prefered_course;

	/*
	 * Student constructor to initialize student data
	 * 
	 * @param a List of student data
	 */
	public Student(List<String> student_data) {
		this.student_name = student_data.get(0);
		
		this.prefered_course = new ArrayList<String>();
		prefered_course.add(student_data.get(1));
		prefered_course.add(student_data.get(2));
		prefered_course.add(student_data.get(3));
		prefered_course.add(student_data.get(4));
		prefered_course.add(student_data.get(5));
	}

	/*
	 * Method to display student details
	 */
	public void display() {
		System.out.println(student_name);
		for (String course_name : prefered_course) {
			System.out.print(course_name + " ");
		}
		System.out.println();
	}

	/*
	 * Method to get Student name
	 * 
	 * @return student_name
	 */
	public String getName() {
		return student_name;
	}

	/*
	 * Method to get student preferred course list
	 * 
	 * @return list of preferred course list
	 */
	public List<String> getPreferedList() {
		return prefered_course;
	}
}
