package TreeAndGraph_Q2;

public class Priority_Queue {
	private int front, rear, capacity;
	private int priority_queue[][];

	/*
	 * Queue constructor for initializing size of the queue
	 * 
	 * @param capacity of the queue
	 */
	Priority_Queue(int capacity) {
		front = rear = 0;
		this.capacity = capacity;
		priority_queue = new int[capacity][2];
	}

	/*
	 * Method to check full of queue
	 * 
	 * @return true is queue is full otherwise false
	 */
	public boolean isFull() {
		if (capacity == rear) {
			return true;
		}

		return false;
	}

	/*
	 * Method to insert element in the queue
	 * @param data to be insert
	 */
	public void Enqueue(int data, int priority) {
		if (isFull()) {
			System.out.println("Queue is full.");
			return;
		} else {
			priority_queue[rear][0] = priority;
			priority_queue[rear][1] = data;
			rear++;
		}
		return;
	}

	/*
	 * Method to check empty of queue
	 * 
	 * @return true is queue is empty otherwise false
	 */
	public boolean isEmpty() {
		if (front == rear) {
			return true;
		}

		return false;
	}

	/*
	 * Method to delete element from queue
	 */
	public void Dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		} else {
			 int highPriorityIndex = peek(); 
			  
			    // Shift the element one index before 
			    // from the postion of the element 
			    // with highest priortity is found 
			    for (int i = highPriorityIndex; i < capacity; i++) { 
			        priority_queue[i][0] = priority_queue[i + 1][0];
			        priority_queue[i][1] = priority_queue[i + 1][1];
			    } 
			  
			    // Decrease the size of the 
			    // priority queue by one 
			    capacity--; 
		}
		return;
	}
	
	public int peek() 
	{ 
		if(isEmpty()){
			return -1;
		}
		
	    int highestPriorityIndex = 0; 
	    int highestPriority = priority_queue[0][0]; 
	  
	    // Check for the element with 
	    // highest priority 
	    for (int i = 1; i < capacity; i++) { 
	    	if(highestPriority > priority_queue[i][0]){
	    		highestPriority = priority_queue[i][0];
	    		highestPriorityIndex = i;
	    	}
	    } 
	  
	    return highestPriorityIndex; 
	} 

	/*
	 * Method to display queue
	 */
	public void Display() {
		int i;
		if (isEmpty()) {
			System.out.printf("\nQueue is Empty\n");
			return;
		}

		for (i = front; i < rear; i++) {
			System.out.print(priority_queue[i][0] + "->" + priority_queue[i][1]+" ");
		}
		return;
	}
}
