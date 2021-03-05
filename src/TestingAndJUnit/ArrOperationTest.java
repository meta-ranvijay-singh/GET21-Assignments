package TestingAndJUnit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;


@RunWith(Parameterized.class)
public class ArrOperationTest {
	
	private static ArrOperation AO;
	
	@Parameter(0)
	public int X;
	
	@Parameter(1)
	public int Y;
	
	@Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{4, 5}};
        return Arrays.asList(data);
    }
	
	
	@BeforeClass
	public static void init(){
		AO=new ArrOperation();	
	}
	
	
	/**
	 * JUnit Test case for maxMirror() method 
	 */
	@Test(expected = AssertionError.class)
	public void maxMirrorTestCase() {
		//assertEquals(3, AO.maxMirror( new int[]{1, 2, 3, 8, 9, 3, 2, 1} ) );
		//assertEquals(2, AO.maxMirror(new int[]{7, 1, 4, 9, 7, 4, 1}));
		//assertEquals(3, AO.maxMirror(new int[]{1, 2, 1, 4}));
		assertSame(10, AO.maxMirror(new int[]{1,2,3,1,2,4,2,1}));
		//assertEquals(1, AO.maxMirror(new int[]{1}));
		//assertEquals(2, AO.maxMirror(new int[]{1,-2,3,2,1}));
		
		//assertEquals(AssertionError.class, AO.maxMirror(new int[]{}));
		//assertEquals(AssertionError.class, AO.maxMirror(null));
	}
	
	/**
	 * JUnit Test case for countClupms() method 
	 */
	@Test(expected = AssertionError.class)
	public void countClumpsTestCase() {
		assertEquals(2, AO.countClumps( new int[]{1, 2, 2, 3, 4, 4} ) );
		assertEquals(2, AO.countClumps(new int[]{1, 1, 2, 1, 1}));
		assertEquals(1, AO.countClumps(new int[]{1, 1, 1, 1, 1}));
		assertEquals(1, AO.countClumps(new int[]{1, 4, -3, -3, 5, 4, 1}));
		assertEquals(0, AO.countClumps(new int[]{1}));
		
		assertEquals(AssertionError.class, AO.countClumps(new int[]{}));
		assertEquals(AssertionError.class, AO.countClumps(null));

	}
	
	/**
	 * JUnit Test case for fixXY() method 
	 */
	@Test(expected = AssertionError.class)
	public void fixXYTestCase() {
	assertArrayEquals(new int[]{9, 4, 5, 4, 5, 9} , AO.fixXY( new int[]{5, 4, 9, 4, 9, 5},X,Y ) );
	assertArrayEquals(new int[]{1, 4, 5, 1}, AO.fixXY(new int[]{1, 4, 1, 5},X,Y));
	assertArrayEquals(new int[]{1, 4, 5, 1, 1, 4, 5}, AO.fixXY(new int[]{1, 4, 1, 5, 5, 4, 1},X,Y));


	assertEquals(AssertionError.class, AO.fixXY(new int[]{},X,Y));
	assertEquals(AssertionError.class, AO.fixXY(new int[]{5, 4, 9, 4, 4, 6,5},X,Y));
	assertEquals(AssertionError.class, AO.fixXY(new int[]{5, 4, 9, 5, 7, 6,4},X,Y));
	assertEquals(AssertionError.class, AO.fixXY(new int[]{5, 4, 9, 5, 4, 6,5},X,Y));
	assertEquals(AssertionError.class, AO.fixXY(null,X,Y));

	}
	
	/**
	 * JUnit Test case for splitArray() method 
	 */
	@Test(expected = AssertionError.class)
	public void splitArrayTestCase() {
		assertEquals(3, AO.splitArray( new int[]{1, 1, 1, 2, 1} ) );
		assertEquals(-1, AO.splitArray(new int[]{2, 1, 1, 2, 1}));
		assertEquals(1, AO.splitArray(new int[]{10,10}));

		assertEquals(AssertionError.class, AO.splitArray(new int[]{}));
		assertEquals(AssertionError.class, AO.splitArray(null));

	}
	
	

}
