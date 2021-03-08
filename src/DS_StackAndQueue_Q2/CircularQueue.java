package DS_StackAndQueue_Q2;

/*
 * Implementation of circular queue
 */
class CircularQueue {

	private int size, front, rear;
	private int[] queue;

	/*
	 * Queue constructor for initializing size of the queue
	 * 
	 * @param size of the queue
	 */
	CircularQueue(int size) {
		this.size = size;
		this.front = this.rear = -1;
		queue = new int[size];
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
	void Enqueue(int element) {
		if (isEmpty()) {
			front = 0;
			rear = 0;
			queue[rear] = element;
		} else if (isFull()) {
			System.out.println("Queue is overflow..");
		} else {
			rear = (rear + 1) % size;
			queue[rear] = element;
		}
	}

	/*
	 * Method to delete element from queue
	 */
	public void Dequeue() {
		if (isEmpty()) {
			System.out.println("\nQueue is underflow..");
		} else if (front == rear) {
			System.out.println("The dequeued element is " + queue[front]);
			front = -1;
			rear = -1;
		} else {
			System.out.println("The dequeued element is " + queue[front]);
			front = (front + 1) % size;
		}
	}

	/*
	 * Method to display queue
	 */
	void Display() {
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
