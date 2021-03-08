package DS_StackAndQueue_Q1;

public class Stack<T> {
	/**
	 * Node class used to create new node in the linked list.
	 */
	public class Node {
		T data;
		public Node next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	// Head
	public Node head = null;

	/**
	 * Method to insert element in the stack.
	 * 
	 * @param new_data
	 *            data to be insert
	 */
	public void push(T new_data) {
		Node new_node = new Node(new_data);

		if (head == null) {
			head = new_node;
			return;
		}

		new_node.next = head;
		head = new_node;

		return;
	}

	/**
	 * Method to insert element in the stack.
	 */
	public T pop() {

		if (head == null) {
			return null;
		}

		T pop = head.data;
		head = head.next;

		return pop;
	}

	/**
	 * Method to traverse stack.
	 */
	public void traverse() {
		Node tempNode = head;
		if (head == null) {
			System.out.println("Stack is empty");
			return;
		}

		while (tempNode != null) {
			System.out.print("->" + tempNode.data);
			tempNode = tempNode.next;
		}
		System.out.println();
	}

	/**
	 * Method to get peek value of the stack.
	 * 
	 * @return peek value of stack
	 */
	public T peek() {
		T peek = head.data;
		return peek;
	}

	/**
	 * Method to check wheather stack is empty or not.
	 * 
	 * @return true if stack is empty otherwise false
	 */
	public boolean empty() {
		if (head == null)
			return true;
		else
			return false;
	}

}
