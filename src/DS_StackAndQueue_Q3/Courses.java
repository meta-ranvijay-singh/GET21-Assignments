package DS_StackAndQueue_Q3;

/*
 * Class to store course details
 */
public class Courses {
	private String course_name;
	private int seat;

	/*
	 * Courses constructor to initialize course data
	 * 
	 * @param course_name and seat capacity
	 */
	public Courses(String course_name, int seat) {
		this.course_name = course_name;
		this.seat = seat;
	}

	/*
	 * Method to display course details
	 */
	public void display() {
		System.out.print("\n" + course_name + " ");
		System.out.println(seat);
	}

	/*
	 * Method to get Course name
	 * 
	 * @return course_name
	 */
	public String getCourseName() {
		return course_name;
	}

	/*
	 * Method to get seat capacity
	 * 
	 * @return seat
	 */
	public int getSeat() {
		return seat;
	}

	/*
	 * Method to decrease seat capacity by one after allocation
	 */
	public void decreaseSeat() {
		--seat;
	}

}
