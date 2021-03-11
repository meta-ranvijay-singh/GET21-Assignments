package Algorithm1_Q1;

class BinarySearchTree {

	class Node 
	{
		int key, value;
		Node left, right;

		public Node(int key, int value)
		{
			this.key = key;
			this.value=value;
			left = right = null;
		}
	}

	Node root;

	BinarySearchTree() 
	{ 
		root = null; 
	}

	void insert(int key, int value) 
	{ 
		root = insertRec(root, key, value); 
	}

	Node insertRec(Node root, int key, int value)
	{

		if (root == null) 
		{
			root = new Node(key, value);
			return root;
		}

		if (key < root.key)
			root.left = insertRec(root.left, key, value);
		else if (key > root.key)
			root.right = insertRec(root.right, key, value);

		return root;
	}

	// This method mainly calls InorderRec()
	void inorder() 
	{ 
		inorderRec(root); 
	}

	// A utility function to 
	// do inorder traversal of BST
	void inorderRec(Node root)
	{
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key+" -> "+root.value);
			inorderRec(root.right);
		}
	}
}

public class Main{
	public static void main(String[] args)
	{
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(5,50);
		tree.insert(3,30);
		tree.insert(2,20);
		tree.insert(4,40);
		tree.insert(7,70);
		tree.insert(6,60);
		tree.insert(8,80);

		tree.inorder();
	}

}