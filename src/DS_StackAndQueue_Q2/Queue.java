package DS_StackAndQueue_Q2;

/*
 * Linear queue interface using array
 */
public interface Queue<T> {

	/*
	 * Method to check full of queue
	 * 
	 * @return true is queue is full otherwise false
	 */
	public boolean isFull();

	/*
	 * Method to insert element in the queue
	 * 
	 * @param data to be insert
	 */
	public boolean Enqueue(T data);

	/*
	 * Method to check empty of queue
	 * 
	 * @return true is queue is empty otherwise false
	 */
	public boolean isEmpty();

	/*
	 * Method to delete element from queue
	 */
	public T Dequeue();

	/*
	 * Method to display queue
	 */
	public void Display();
}
