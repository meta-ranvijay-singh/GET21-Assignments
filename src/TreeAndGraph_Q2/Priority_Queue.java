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
			for (int i = 0; i < rear - 1; i++) {
				queue[i] = queue[i + 1];
			}
			if (rear < capacity)
				queue[rear] = 0;

			rear--;
		}
		return;
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
			System.out.print(queue[i] + " ");
		}
		return;
	}
}
