package DS_StackAndQueue_Q1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	private EvaluateInfixExpression infix;
	
	@Test
	public void test() {
		infix=new EvaluateInfixExpression();
		
		System.out.println(infix.evaluate("2+2/2"));
		assertSame(3.0, infix.evaluate("2+2/2"));

	}

}
