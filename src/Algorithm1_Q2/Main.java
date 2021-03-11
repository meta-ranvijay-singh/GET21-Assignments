package Algorithm1_Q2;

import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	/*
	 * Method to get employee data
	 * 
	 * @return Employee object
	 */
	public static Employees insertEmployee() {
		System.out.print("Enter employee id :");
		int empid = in.nextInt();

		in.nextLine(); //Used to clear buffer
		System.out.print("Enter employee name :");
		String name = in.nextLine();

		System.out.print("Enter employee age :");
		int age = in.nextInt();

		System.out.print("Enter employee salary :");
		double salary = in.nextDouble();

		return new Employees(empid, name, age, salary);
	}

	public static void main(String[] args) {
		LinkedList employees = new LinkedList();

		Employees employee;
		String choice;
		do {
			employee = insertEmployee();
			employees.sortedInsert(employee);
			in.nextLine(); //Used to clear buffer
			System.out.print("Want to enter more (Y/N) ? :");
			choice = in.nextLine();
		} while ("Y".equals(choice) || "y".equals(choice));

		employees.traverse();

	}

}
