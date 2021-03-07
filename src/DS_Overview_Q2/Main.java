package DS_Overview_Q2;

public class Main {

	public static void main(String[] args) {
		DetectLoopLinkedList linkedList = new DetectLoopLinkedList();

		// Inserting elements in the linked list
		linkedList.insertLast(2);
		linkedList.insertLast(0);
		linkedList.insertLast(6);
		linkedList.insertLast(3);
		linkedList.insertLast(1);

		// Making loop in linked list
		linkedList.head.next.next.next.next = linkedList.head.next.next;

		if (linkedList.detectLoop()) {
			System.out.println("Loop found");
		} else {
			System.out.println("Loop not found");
		}

	}

}
