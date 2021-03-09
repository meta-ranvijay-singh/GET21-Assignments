package DS_StackAndQueue_Q1;

public interface Stack<T> {
	/**
	 * Method to insert element in the stack.
	 * 
	 * @param new_data
	 *            data to be insert
	 */
	public void push(T new_data);
	
	/**
	 * Method to insert element in the stack.
	 */
	public T pop();

	/**
	 * Method to traverse stack.
	 */
	public void traverse();

	/**
	 * Method to get peek value of the stack.
	 * 
	 * @return peek value of stack
	 */
	public T peek();

	/**
	 * Method to check wheather stack is empty or not.
	 * 
	 * @return true if stack is empty otherwise false
	 */
	public boolean empty();



}
