package DS_Overview_Q1;

/**
 * Linked List class.
 */
public class LinkedList {

	/**
	 * Node class used to create new node in the linked list.
	 */
	class Node {
		int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node head = null;

	/**
	 * Method to get sublist from base linked list.
	 * 
	 * @param start
	 *            starting position and end ending position
	 * @return newList a sub list of linkedList
	 */
	public LinkedList getSubList(int start, int end) {
		LinkedList newList = new LinkedList();

		if (start < 1 || end < start) {
			System.out.println("Enter valid start/end position.");
			return newList;
		}

		Node tempNode = head;

		for (int i = 1; tempNode != null && i <= end; ++i) {
			if (i >= start && i <= end) {
				newList.insertLast(tempNode.data);
			}
			tempNode = tempNode.next;
		}

		return newList;

	}

	/**
	 * Method to rotate linked list in clockwise direction.
	 * 
	 * @param no_of_rotate
	 *            number of rotation
	 */
	public void rotateList(int no_of_rotate) {

		if (no_of_rotate < 1) {
			return;
		}

		if (head == null) {
			return;
		}

		Node tempNode = head;

		for (int i = 1; i < no_of_rotate && tempNode != null; ++i) {
			tempNode = tempNode.next;
		}

		if (tempNode == null)
			return;

		Node shiftNode = tempNode;

		while (tempNode.next != null) {
			tempNode = tempNode.next;
		}

		tempNode.next = head;
		head = shiftNode.next;
		shiftNode.next = null;

	}

	/**
	 * Method to insert element in the last position in linked list.
	 * 
	 * @param new_data
	 *            data to be insert
	 */
	public void insertLast(int new_data) {
		Node new_node = new Node(new_data);

		if (head == null) {
			head = new_node;
			return;
		}

		Node last = head;
		while (last.next != null)
			last = last.next;

		last.next = new_node;
		return;
	}

	/**
	 * Method to add a sub list in between in linkedlist.
	 * 
	 * @param subList
	 *            a sub list that is to be added, start starting position and
	 *            end ending position where sublist is to be added
	 * @return newList a new linked list after adding sublist
	 */
	public LinkedList addSubList(LinkedList subList, int start, int end) {
		LinkedList newList = new LinkedList();

		if (start < 1 || end < start) {
			System.out.println("Enter valid start/end position.");
			return newList;
		}

		Node tempNode = head;

		for (int i = 1; i < start && tempNode != null; ++i) {
			newList.insertLast(tempNode.data);
			tempNode = tempNode.next;
		}

		while (tempNode != null && subList.head != null) {
			newList.insertLast(subList.head.data);

			tempNode = tempNode.next;
			subList.head = subList.head.next;
		}

		while (tempNode != null) {
			newList.insertLast(tempNode.data);
			tempNode = tempNode.next;

		}

		return newList;

	}

	/**
	 * Method to compare two linked list.
	 * 
	 * @param passedList
	 *            a linked list that is to be compared
	 * @return true is both are equal otherwise false
	 */
	public boolean checkEqual(LinkedList passedList) {

		Node tempNode1 = head;
		Node tempNode2 = passedList.head;
		while (tempNode1 != null || tempNode2 != null) {
			if (tempNode1.data != tempNode2.data) {
				return false;
			}
			tempNode1 = tempNode1.next;
			tempNode2 = tempNode2.next;
		}
		return true;
	}

	/**
	 * Method to traverse linked list.
	 */
	public void traverse() {
		Node tempNode = head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		while (tempNode != null) {
			System.out.print("->" + tempNode.data);
			tempNode = tempNode.next;
		}
		System.out.println();
	}

}
