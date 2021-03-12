package Algorithm1_Q1;

import java.util.List;

//Dictionary interface
public interface Dictionary {
	
	/*Method to add key value pair in the dictionary
	 * @param key value
	 */
	public void add(int key, int val);
	
	/*
	 * Method to remove key-value pair from dictionary
	 * @param key to remove
	 */
	public void remove(int key);
	
	/*
	 * Method to get value of a specific key
	 */
	public Integer getValue(int key);
	
	/*
	 * Method to get list of sorted dictionary
	 */
	public List<BinarySearchTree.Node> sort();
}
