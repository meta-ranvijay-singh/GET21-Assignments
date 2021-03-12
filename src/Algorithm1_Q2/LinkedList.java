package Algorithm1_Q2;

/*
 * Linked List of Employee
 */
public class LinkedList {

	/*
	 * Employee Node
	 */
	class Node {
		Employees employee;
		Node next;

		Node(Employees employee) {
			this.employee = employee;
			next = null;
		}
	}

	public Node head;

	public LinkedList() {
		head = null;
	}

	/*
	 * Method to implement insertion sort
	 * 
	 * @param passedEmployee an Employee to insert
	 */
	void sortedInsert(Employees passedEmployee) {
		Node newnode = new Node(passedEmployee);

		if (head == null || head.employee.compareTo(newnode.employee) > 0) {
			newnode.next = head;
			head = newnode;
		} else {
			Node currentNode = head;
			// Loop for finding the node before the point of insertion
			while (currentNode.next != null
					&& currentNode.next.employee.compareTo(newnode.employee) < 0) {
				currentNode = currentNode.next;
			}
			newnode.next = currentNode.next;
			currentNode.next = newnode;
		}
	}

	/*
	 * Method to traverse node
	 */
	public void traverse() {
		Node tempHead = head;
		while (tempHead != null) {
			System.out.println(tempHead.employee);
			tempHead = tempHead.next;
		}
	}
}
