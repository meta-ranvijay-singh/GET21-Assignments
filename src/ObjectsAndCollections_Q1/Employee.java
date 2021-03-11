package ObjectsAndCollections_Q1;

/*
 * Employee class implementing Comparable interface
 */
public class Employee implements Comparable<Employee> {
	private int empid;
	private String name, address;

	/*
	 * Employee Constructor initializing employee data
	 */
	public Employee(int empid, String name, String address) {
		this.empid = empid;
		this.name = name;
		this.address = address;
	}

	/*
	 * Method to get employee ID
	 * 
	 * @return empid employee ID of the employee
	 */
	public int getEmpId() {
		return empid;
	}

	/*
	 * Method to get employee name
	 * 
	 * @return name of the employee
	 */
	public String getName() {
		return name;
	}

	/*
	 * Overriding toString() method
	 */
	public String toString() {
		return "EmpId :" + empid + " Name :" + name + " Address :" + address;

	}

	/*
	 * Overriding compareTo() method
	 */
	@Override
	public int compareTo(Employee employee) {
		return name.compareTo(employee.getName());
	}

}
