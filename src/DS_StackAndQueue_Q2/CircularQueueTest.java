package DS_StackAndQueue_Q2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {

	CircularQueue circular_queue;
	
	@Test
	public void test() {
		circular_queue=new CircularQueue(5);
		
		circular_queue.Enqueue(1);
		circular_queue.Enqueue(2);
		circular_queue.Enqueue(3);
		circular_queue.Enqueue(4);
		circular_queue.Enqueue(5);
		
		
		
	}

}
