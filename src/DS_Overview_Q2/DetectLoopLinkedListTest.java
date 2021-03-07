package DS_Overview_Q2;

import static org.junit.Assert.*;

import org.junit.Test;

public class DetectLoopLinkedListTest {
	private DetectLoopLinkedList linkedList;

	/*
	 * Positive test case.
	 */
	@Test
	public void testDetectLoop() {
		linkedList = new DetectLoopLinkedList();

		linkedList.insertLast(2);
		linkedList.insertLast(0);
		linkedList.insertLast(6);
		linkedList.insertLast(3);
		linkedList.insertLast(1);

		linkedList.head.next.next.next.next = linkedList.head.next.next;

		assertTrue(linkedList.detectLoop());
	}

	/*
	 * Negative test case.
	 */
	@Test
	public void testDetectLoopCase2() {
		linkedList = new DetectLoopLinkedList();

		linkedList.insertLast(2);
		linkedList.insertLast(0);
		linkedList.insertLast(6);
		linkedList.insertLast(3);
		linkedList.insertLast(1);

		assertFalse(linkedList.detectLoop());
	}

}
