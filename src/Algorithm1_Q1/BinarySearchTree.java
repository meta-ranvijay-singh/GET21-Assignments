package Algorithm1_Q1;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

/*
 * Binary search tree
 */
public class BinarySearchTree implements Dictionary {
	//Node class
	public class Node {
		int key, value;
		Node left, right;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			left = right = null;
		}
	}

	Node root;
	List<Node> sortedList;

	//Constructor
	BinarySearchTree(JSONObject json) {
		root = null;
		
		for(Object key:json.keySet()){
			
			//System.out.println(str.toString());
			add(Integer.parseInt(key.toString()), Integer.parseInt(json.get(key).toString()));
		}
	}

	/*
	 * Overriding add method of Dictionary interface
	 * @param key value pair
	 */
	@Override
	public void add(int key, int value) {
		root = insert(root, key, value);
	}

	Node insert(Node root, int key, int value) {
		if (root == null) {
			root = new Node(key, value);
			return root;
		}

		if (key < root.key)
			root.left = insert(root.left, key, value);
		else if (key > root.key)
			root.right = insert(root.right, key, value);

		return root;
	}

	/*
	 * Overriding getValue method of Dictionary interface
	 * @param key to search value
	 * @return value corresponding to its key
	 */
	@Override
	public Integer getValue(int key) {
		Node resultedNode = search(root, key);
		if (resultedNode == null) {
			return null;
		}

		return resultedNode.value;
	}

	/*
	 * Support method for searching key recursively
	 * @param root node and key to search
	 * @return node
	 */
	public Node search(Node root, int key) {

		if (root == null || root.key == key) {
			return root;
		}

		if (root.key < key) {
			return search(root.right, key);
		}
		return search(root.left, key);
	}

	/*
	 * Overriding sort method of Dictionary interface
	 * @return sorted list
	 */
	@Override
	public List<Node> sort() {
		sortedList = new ArrayList<BinarySearchTree.Node>();
		inorderTraverse(root);
		return sortedList;

	}

	/*
	 * Support method for sort method, 
	 */
	void inorderTraverse(Node root) {
		if (root != null) {
			inorderTraverse(root.left);
			sortedList.add(root);
			inorderTraverse(root.right);
		}
	}

	/*
	 * Overriding remove method of dictionary
	 * @param key to delete that key value pair
	 */
	@Override
	public void remove(int key) {
		root = deleteRecursive(root, key);
	}

	/*
	 * Support method to delete node recursively
	 * @param root node and key to delete
	 */
	Node deleteRecursive(Node root, int key) {
		if (root == null) {
			return root;
		}
		if (key < root.key) {
			root.left = deleteRecursive(root.left, key);
		} else if (key > root.key) {
			root.right = deleteRecursive(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			root.key = minKey(root.right);
			root.value = minValue(root.right);
			root.right = deleteRecursive(root.right, root.key);
		}

		return root;
	}

	/*
	 * method to return minimum key 
	 */
	int minKey(Node root) {
		int minKey = root.key;
		while (root.left != null) {
			minKey = root.left.key;
			root = root.left;
		}
		return minKey;
	}

	/*
	 * method to return minimum value
	 */
	int minValue(Node root) {
		int minValue = root.value;
		while (root.left != null) {
			minValue = root.left.value;
			root = root.left;
		}
		return minValue;
	}
}
