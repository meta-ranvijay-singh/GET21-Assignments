package TreeAndGraph_Q1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
 * Tree
 */
public class TreeDirectory {

	/*
	 * Node class
	 */
	public class Node {
		String directory_name;
		List<Node> sub_directory;
		Node parent_node;
		Date createdDate;

		// Node Constructor
		public Node(String directoryName) {
			directory_name = directoryName;
			sub_directory = new ArrayList<Node>();
			parent_node = null;
			createdDate = Calendar.getInstance().getTime();
		}
	}

	public Node root;
	public Node current_node;

	// TreeDirectory Constructor
	public TreeDirectory() {
		root = new Node(".");
		current_node = root;
	}

	/*
	 * Method to make directory
	 * 
	 * @param directoryName
	 * 
	 * @return true after making directory node
	 */
	public boolean makeDirectory(String directoryName) {
		Node new_node = new Node(directoryName);

		new_node.parent_node = current_node;
		current_node.sub_directory.add(new_node);

		return true;

	}

	/*
	 * Method to change directory
	 * 
	 * @param directoryName
	 * 
	 * @return changed directory name if directory found otherwise null
	 */
	public String changeDirectory(String directory_name) {
		for (Node subDirectory : current_node.sub_directory) {
			if (directory_name.equals(subDirectory.directory_name)) {
				current_node = subDirectory;
				return current_node.directory_name;
			}
		}
		return "null";
	}

	/*
	 * Method to go back directory
	 * 
	 * @return true if it moved back else false
	 */
	public boolean back() {
		if (current_node == root) {
			return false;
		} else {
			current_node = current_node.parent_node;
			return true;
		}
	}

	/*
	 * Method to find directory in the current directory recursively
	 * 
	 * @param current_folder where to find, directoryName to be find
	 * 
	 * @return true if folder found in the current directory otherwise false
	 */
	public boolean findDirectory(Node current_folder, String directoryName) {
		boolean flag = false;
		if (current_folder.directory_name.equals(directoryName)) {
			return true;
		}
		for (Node subNode : current_folder.sub_directory) {
			if (findDirectory(subNode, directoryName)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * Method to display tree structure from given root
	 * 
	 * @param directory node whose display tree structure
	 */
	public void displayTree(Node root, int i) {
		Node tempRoot = root;
		for (int j = 0; j < i; ++j) {
			System.out.print("\t");
		}
		System.out.println(tempRoot.directory_name);
		for (Node subNode : tempRoot.sub_directory) {
			displayTree(subNode, i + 1);
		}

	}

	/*
	 * Method to list all the folders in the current directory
	 */
	public void listOfFolder() {
		Node tempRoot = current_node;
		//Loop to scan each sub directory
		for (Node subNode : tempRoot.sub_directory) {
			System.out.println(subNode.createdDate + "\t"
					+ subNode.directory_name);

		}
		System.out.println(tempRoot.sub_directory.size() + " Folder"
				+ (tempRoot.sub_directory.size() > 1 ? "(s)" : ""));

	}
}
