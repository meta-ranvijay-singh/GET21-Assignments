package DS_Overview_Q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedList linkedList = new LinkedList();
		String choice;

		System.out.println("Insert element to LinkedList : ");

		/**
		 * do-while loop for inserting elements
		 */
		do {
			System.out.print("Element : ");
			linkedList.insertLast(in.nextInt());
			System.out.print("Want to enter more (Y/N) ? : ");
			choice = in.next();

		} while ("Y".equals(choice) || "y".equals(choice));

		/**
		 * Display input linked list
		 */
		System.out.println("Nodes of linked list: ");
		linkedList.traverse();

		System.out.print("Enter the stating and ending position of sublist : ");
		int start = in.nextInt();
		int end = in.nextInt();

		LinkedList subList = linkedList.getSubList(start, end);
		System.out.println("Nodes of sub list: ");
		subList.traverse();

		if (subList.head != null) {
			System.out.print("Enter No. of rotation : ");
			int no_of_rotation = in.nextInt();

			subList.rotateList(no_of_rotation);

			linkedList = linkedList.addSubList(subList, start, end);

			linkedList.traverse();
		}

	}

}
