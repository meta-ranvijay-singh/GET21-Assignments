package Recursion_Q1;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class MathematicsTest {
	private static Mathematics math;
	
	@BeforeClass
	public static void init(){
		math=new Mathematics();
	}
	
	
	/**
	 * JUnit Test case for findLCM() method 
	 */
	@Test
	public void testLCM() {
		assertEquals(12, math.findLCM(3, 4));
		assertEquals(0, math.findLCM(3, 0));
		assertEquals(6, math.findLCM(-6, 2));
		assertEquals(6, math.findLCM(-6, -2));
	}
	
	/**
	 * JUnit Test case for findHCF() method 
	 */
	@Test
	public void testHCF() {
		assertEquals(1, math.findHCF(3, 4));
		assertEquals(3, math.findHCF(3, 0));
		assertEquals(1, math.findHCF(-3, -4));
		assertEquals(2, math.findHCF(-6, 2));

	}

}
