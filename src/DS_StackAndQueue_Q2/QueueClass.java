package DS_StackAndQueue_Q2;

public class QueueClass<T> implements Queue<T> {
	private int front, rear, capacity;
	private T queue[];

	/*
	 * Queue constructor for initializing size of the queue
	 * 
	 * @param capacity of the queue
	 */
	public QueueClass(int capacity) {
		front = rear = 0;
		this.capacity = capacity;
		queue = (T[]) new Object[capacity];
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
	 * 
	 * @param data to be insert
	 */
	public boolean Enqueue(T data) {
		if (isFull()) {
			return false;
		} else {
			queue[rear] = data;
			rear++;
		}
		return true;
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
	public T Dequeue() {
		T tempElement;
		if (isEmpty()) {
			return null;
		} else {
			tempElement = queue[0];
			for (int i = 0; i < rear - 1; i++) {
				queue[i] = queue[i + 1];
			}
			if (rear < capacity)
				queue[rear] = null;

			rear--;
		}
		return tempElement;
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