package Recursion_Q2;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SearchTest {

	private static Search search;
	
	@BeforeClass
	public static void init(){
		search=new Search();
	}
	
	/**
	 * JUnit Test case for Linear Search 
	 */
	@Test(expected = AssertionError.class)
	public void testLinearSeach() {
		assertEquals(0, search.LinearSearch(new int[]{1,2,3,4,5}, 1));
		assertEquals(-1, search.LinearSearch(new int[]{1,2,3,4,5}, 10));
		assertEquals(2, search.LinearSearch(new int[]{1,2,-3,4,5}, -3));
		assertEquals(AssertionError.class, search.LinearSearch(new int[]{}, 3));
	}
	
	/**
	 * JUnit Test case for Binary Search 
	 */
	@Test(expected = AssertionError.class)
	public void testBinarySeach() {
		assertEquals(0, search.BinarySearch(new int[]{1,2,3,4,5}, 1));
		assertEquals(-1, search.BinarySearch(new int[]{1,2,3,4,5}, 10));
		assertEquals(2, search.BinarySearch(new int[]{1,2,-3,4,5}, -3));
		assertEquals(AssertionError.class, search.BinarySearch(new int[]{}, 3));
	}

}
