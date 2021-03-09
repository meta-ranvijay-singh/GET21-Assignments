package DS_StackAndQueue_Q2;

import DS_StackAndQueue_Q1.Stack;

/*
 * Implementation of circular queue
 */
class CircularQueue<T> implements Queue<T> {

	private int size, front, rear;
	private T[] queue;

	/*
	 * Queue constructor for initializing size of the queue
	 * 
	 * @param size of the queue
	 */
	CircularQueue(int size) {
		this.size = size;
		this.front = this.rear = -1;
		queue = (T[])new Object[size];
	}

	/*
	 * Method to check full of queue
	 * 
	 * @return true is queue is full otherwise false
	 */
	public boolean isFull() {
		if ((rear + 1) % size == front) {
			return true;
		}

		return false;
	}

	/*
	 * Method to check empty of queue
	 * 
	 * @return true is queue is empty otherwise false
	 */
	public boolean isEmpty() {
		if (front == -1 && rear == -1) {
			return true;
		}
		return false;
	}

	 /*
	 * Method to insert element in the queue
	 * 
	 * @param element to be insert
	 */
	public boolean Enqueue(T element) {
		if (isEmpty()) {
			front = 0;
			rear = 0;
			queue[rear] = element;
			return true;
		} else if (isFull()) {
			return false;
		} else {
			rear = (rear + 1) % size;
			queue[rear] = element;
			return true;
		}
	}

	/*
	 * Method to delete element from queue
	 */
	public T Dequeue() {
		T element;
		if (isEmpty()) {
			return null;
		} else if (front == rear) {
			element=queue[front];
			front = -1;
			rear = -1;
		} else {
			element=queue[front];
			front = (front + 1) % size;
		}
		return element;
	}

	 /*
	 * Method to display queue
	 */
	public void Display() {
		int i;
		if (isEmpty()) {
			System.out.println("Queue is empty.");
		} else {
			System.out.println("Front -> " + front);
			System.out.print("Items -> ");
			for (i = front; i != rear; i = (i + 1) % size)
				System.out.print(queue[i] + " ");
			System.out.println(queue[i]);
			System.out.println("Rear -> " + rear);
		}
	}
}
