package DS_Overview_Q2;

import DS_Overview_Q1.LinkedList;

/**
 * Extending class Linked List from package DS_Overview_Q1.LinkedList
 */
public class DetectLoopLinkedList extends LinkedList {

	/**
	 * Method to detect loop in the linked list.
	 * 
	 * @return true if loop found otherwise false
	 */
	public boolean detectLoop() {

		Node tortoise = head, hare = head;

		while (tortoise != null && hare != null && hare.next != null) {
			tortoise = tortoise.next;
			hare = hare.next.next;
			if (tortoise == hare) {
				return true;
			}
		}

		return false;

	}
}
