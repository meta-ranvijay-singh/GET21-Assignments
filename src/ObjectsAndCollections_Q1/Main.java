package ObjectsAndCollections_Q1;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	static Scanner in = new Scanner(System.in);

	// Main menu
	public static void menu() {
		System.out.println("\n-----MENU------");
		System.out.println("1. Sort on the basis of Emp. ID");
		System.out.println("2. Sort on the basis of Emp. Name");
		System.out.println("3. Display Employee list");
		System.out.println("0. Exit");
		System.out.print("Enter choice :");
	}

	/*
	 * Method to insert employee data
	 * 
	 * @return Employee object
	 */
	public static Employee insertEmployee() {
		System.out.print("Enter Employee ID :");
		int empid = in.nextInt();
		in.nextLine();
		System.out.print("Enter Employee Name :");
		String name = in.nextLine();

		System.out.print("Enter Employee Address :");
		String address = in.nextLine();

		return new Employee(empid, name, address);
	}

	/*
	 * Method to print Employee Collection
	 * 
	 * @param Map<Integerr, Employee> map of employees
	 */
	public static void printMap(Map<Integer, Employee> employeeMap) {
		for (Map.Entry<Integer, Employee> employee : employeeMap.entrySet()) {
			System.out.println("Key : " + employee.getKey() + " Value : "
					+ employee.getValue().toString());
		}
	}

	/*
	 * Method to sort employee map on the basis of employee name
	 * 
	 * @param passedMap to sort it
	 */
	public static Map<Integer, Employee> sortByName(
			Map<Integer, Employee> passedMap) {
		// Creating list from HashMap
		List<Map.Entry<Integer, Employee>> mapList = new LinkedList<Map.Entry<Integer, Employee>>(
				passedMap.entrySet());

		// Sorting the list
		Collections.sort(mapList,
				new Comparator<Map.Entry<Integer, Employee>>() {
					public int compare(Map.Entry<Integer, Employee> employee1,
							Map.Entry<Integer, Employee> employee2) {
						return (employee1.getValue()).compareTo(employee2
								.getValue());
					}
				});

		// Put data from sorted list to hashmap
		HashMap<Integer, Employee> EmpMap = new LinkedHashMap<Integer, Employee>();
		for (Map.Entry<Integer, Employee> employee : mapList) {
			EmpMap.put(employee.getKey(), employee.getValue());
		}
		return EmpMap;
	}

	public static void main(String[] args) {
		Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

		int choice;
		String enteryChoice;
		Employee emplyee;

		do {
			emplyee = insertEmployee();
			if (employees.put(emplyee.getEmpId(), emplyee) == null) {
				System.out.println("Employee added successfully.");
			} else {
				System.out.println("Employee ID already present.");
			}

			System.out.print("Want to enter more(Y/N)? :");
			enteryChoice = in.nextLine();

		} while (enteryChoice.equals("Y") || enteryChoice.equals("y"));

		do {
			menu();
			choice = in.nextInt();

			switch (choice) {
			case 1:
				Map<Integer, Employee> treeMap = new TreeMap<Integer, Employee>(
						employees);
				printMap(treeMap);
				break;
			case 2:
				Map<Integer, Employee> sortedMap = sortByName(employees);
				printMap(sortedMap);
				break;
			case 3:
				printMap(employees);
				break;
			default:
				break;
			}
		} while (choice != 0);
	}

}
