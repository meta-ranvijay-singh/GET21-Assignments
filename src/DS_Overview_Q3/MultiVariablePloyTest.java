package DS_Overview_Q3;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MultiVariablePloyTest {
	private MultiVariablePloy polynomial;
	private List<String> variable;
	private List<Integer> power;
	
	/*
	 * Positive test case
	 */
	@Test
	public void testFindDegree() {
		polynomial=new MultiVariablePloy();
		
		variable=new ArrayList<String>();
		power=new ArrayList<Integer>();
		variable.add("x");
		power.add(2);
		variable.add("z");
		power.add(3);
		polynomial.insertLast(4, variable, power);
		
		variable=new ArrayList<String>();
		power=new ArrayList<Integer>();
		variable.add("y");
		power.add(5);
		variable.add("z");
		power.add(1);
		polynomial.insertLast(2, variable, power);

		assertEquals(6, polynomial.findDegree());
		
	}
	
	/*
	 * Negative test case
	 */
	@Test
	public void testFindDegreeNegativeCase() {
		polynomial=new MultiVariablePloy();
		
		variable=new ArrayList<String>();
		power=new ArrayList<Integer>();
		variable.add("x");
		power.add(-2);
		variable.add("z");
		power.add(3);
		polynomial.insertLast(-4, variable, power);
		
		variable=new ArrayList<String>();
		power=new ArrayList<Integer>();
		variable.add("y");
		power.add(-5);
		variable.add("z");
		power.add(1);
		polynomial.insertLast(2, variable, power);

		assertEquals(1, polynomial.findDegree());
		
	}

}
