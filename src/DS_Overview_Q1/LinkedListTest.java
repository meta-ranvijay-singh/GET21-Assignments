package DS_Overview_Q1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for LinkedList
 */
public class LinkedListTest {
	private LinkedList linkedList;

	/**
	 * Positive test case
	 */
	@Test
	public void positiveTestCase1() {
		linkedList = new LinkedList();
		LinkedList matchList = new LinkedList();

		int[] input = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		for (int i = 0; i < input.length; ++i) {
			linkedList.insertLast(input[i]);
		}

		int[] matchInput = { 10, 7, 6, 9, 8, 5, 4, 3, 2, 1 };
		for (int i = 0; i < matchInput.length; ++i) {
			matchList.insertLast(matchInput[i]);
		}

		LinkedList subList = linkedList.getSubList(2, 5);
		subList.rotateList(2);

		linkedList = linkedList.addSubList(subList, 2, 5);
		assertTrue(linkedList.checkEqual(matchList));

	}

	/**
	 * Negative test case1.
	 */
	@Test
	public void negativeTestCase1() {
		linkedList = new LinkedList();
		LinkedList matchList = new LinkedList();

		int[] input = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		for (int i = 0; i < input.length; ++i) {
			linkedList.insertLast(input[i]);
		}

		int[] matchInput = { 10, 9, 8, 7, 4, 3, 2, 1, 6, 5, };
		for (int i = 0; i < matchInput.length; ++i) {
			matchList.insertLast(matchInput[i]);
		}

		LinkedList subList = linkedList.getSubList(5, 20);
		subList.rotateList(2);

		linkedList = linkedList.addSubList(subList, 5, 20);
		assertTrue(linkedList.checkEqual(matchList));

	}

	/**
	 * Negative test case2.
	 */
	@Test
	public void negativeTestCase2() {
		linkedList = new LinkedList();
		LinkedList matchList = new LinkedList();

		int[] input = { 10, 9, -8, 7, 6, -5, 4, 3, 2, 1 };
		for (int i = 0; i < input.length; ++i) {
			linkedList.insertLast(input[i]);
		}

		int[] matchInput = { 10, 9, -8, 7, 4, 3, 2, 1, 6, -5, };
		for (int i = 0; i < matchInput.length; ++i) {
			matchList.insertLast(matchInput[i]);
		}

		LinkedList subList = linkedList.getSubList(5, 20);
		subList.rotateList(2);

		linkedList = linkedList.addSubList(subList, 5, 20);
		assertTrue(linkedList.checkEqual(matchList));

	}

}
