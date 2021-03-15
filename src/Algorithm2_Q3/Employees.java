package Algorithm2_Q3;

/*
 * Employee class
 */
public class Employees implements Comparable<Employees> {
	private String name;
	private int empid, age;
	private double salary;

	/*
	 * Employee Constructor to initialize employee details
	 * 
	 * @param empId employee ID, empName employee name, age employee age, salary
	 * employee per month salary
	 */
	public Employees(int empId, String empName, int age, double salary) {
		empid = empId;
		name = empName;
		this.age = age;
		this.salary = salary;
	}

	/*
	 * Method to get age of the employee
	 * 
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/*
	 * Method to get salary of the employee
	 * 
	 * @return salary
	 */
	public double getSalary() {
		return salary;
	}

	/*
	 * overriding toString() method
	 */
	public String toString() {
		return "\nEmpID \t:" + empid + "\nName \t:" + name + "\nAge \t:" + age
				+ "\nSalary \t:" + salary;
	}

	/*
	 * Overriding compareTo method
	 * 
	 * @param employee to compare
	 * 
	 * @return 1 if the passed employee salary is greater otherwise it return -1
	 * alse if both employee having same salary then it return 1 if passed
	 * employee age is lesser otherwise -1
	 */
	@Override
	public int compareTo(Employees employee) {
		if (salary < employee.getSalary()) {
			return 1;
		} else if (salary == employee.getSalary()) {
			if (age > employee.getAge()) {
				return 1;
			} else {
				return -1;
			}
		}

		return -1;
	}

}