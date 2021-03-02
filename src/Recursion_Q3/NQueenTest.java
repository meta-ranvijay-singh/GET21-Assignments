package Recursion_Q3;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenTest {

	@Test
	public void testNQueen() {
		NQueen queen=new NQueen();
		assertTrue(queen.nQueen(new int[4][4], 0, 4));
		assertTrue(queen.nQueen(new int[8][8], 0, 8));
		assertFalse(queen.nQueen(new int[3][3], 0, 3));
		
	}

}
