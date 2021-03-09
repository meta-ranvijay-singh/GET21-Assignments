package TreeAndGraph_Q2;

import java.util.NoSuchElementException;

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
	 * 
	 * @param data to be insert
	 */
	public boolean Enqueue(int data, int priority) {
		if (isFull()) {
			return false;
		} else {
			if (isEmpty()) {
				priority_queue[rear][0] = priority;
				priority_queue[rear][1] = data;
				rear++;
			} else {
				int i;
				// Insertion sort acc. to priority (Low value having highest
				// priority)
				for (i = rear - 1; i >= 0; --i) {
					if (priority_queue[i][0] > priority) {
						priority_queue[i + 1][0] = priority_queue[i][0];
						priority_queue[i + 1][1] = priority_queue[i][1];
					} else {
						break;
					}
				}
				priority_queue[i + 1][0] = priority;
				priority_queue[i + 1][1] = data;
				rear++;
			}

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
	public boolean Dequeue() {
		if (isEmpty()) {
			return false;
		} else {
			for (int i = front; i < rear - 1; i++) {
				priority_queue[i][0] = priority_queue[i + 1][0];
				priority_queue[i][1] = priority_queue[i + 1][1];
			}

			rear--;
		}
		return true;
	}

	/*
	 * Method to get peek value in the priority queue
	 */
	public int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}

		return priority_queue[front][1];
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
			System.out.println(priority_queue[i][0] + "->"
					+ priority_queue[i][1]);
		}
	}
}
