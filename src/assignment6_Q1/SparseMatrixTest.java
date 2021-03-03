package assignment6_Q1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixTest {

	/*
	 * JUnit test case for Sparse Matrix multiplication
	 */
	@Test(expected=AssertionError.class)
	public void testMultiply() {

		SparseMatrix sparseMatrix1=new SparseMatrix(new int[][]{ {0,1,2}, {1,1,1} }, 3, 3);
		assertArrayEquals(new int[][]{{0,2,0},{0,1,0},{0,0,0}}, sparseMatrix1.multiply(new SparseMatrix(new int[][]{{0,1,2}, {1,1,1}}, 3, 3)));
		assertArrayEquals(new int[][]{{0,2,0},{0,1,0},{0,0,0}}, sparseMatrix1.multiply(new SparseMatrix(new int[][]{}, 3, 3)));
		
		sparseMatrix1=new SparseMatrix(new int[][]{ {0,0,3}, {1,2,4} }, 2, 3);
		assertArrayEquals(new int[][]{{0,6},{0,16}}, sparseMatrix1.multiply(new SparseMatrix(new int[][]{{0,1,2}, {2,1,4}}, 3, 2)));
	}

}
