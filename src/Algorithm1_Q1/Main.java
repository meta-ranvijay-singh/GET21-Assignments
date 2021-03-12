package Algorithm1_Q1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Algorithm1_Q1.BinarySearchTree.Node;

public class Main {

	/*
	 * Method to print binary search tree in inorder
	 * @param pasedDictionary list of key-value pair
	 */
	public static void display(List<Node> passedDictionary) {
		List<Node> sortedList = passedDictionary;
		for (Node node : sortedList) {
			System.out.println(node.key + " -> " + node.value);
		}
	}

	/*
	 * Menu
	 */
	static void menu() {
		System.out.println("\n-----MENU------");
		System.out.println("1. Add");
		System.out.println("2. Delete");
		System.out.println("3. Sort");
		System.out.println("4. Dislay");
		System.out.println("0. Exit");
		System.out.print("Enter your choice :");
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ParseException {
		Scanner in = new Scanner(System.in);
		JSONParser jsonParser = new JSONParser();
		Object fileObject = jsonParser
				.parse(new FileReader(
						"C:\\Users\\ranvijay.singh_metac\\workspace\\Assignments\\sample.json"));
		JSONObject json = (JSONObject) fileObject;
		BinarySearchTree binarySearchTree = new BinarySearchTree(json);

		display(binarySearchTree.sort());

		int choice, key, value;

		do {
			menu();
			choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter key :");
				key = in.nextInt();
				System.out.print("Enter value :");
				value = in.nextInt();
				binarySearchTree.add(key, value);
				break;
			case 2:
				System.out.print("Enter key :");
				key = in.nextInt();
				binarySearchTree.remove(key);
				break;
			case 3:
				List<Node> sortedList = binarySearchTree.sort();
				display(sortedList);
				break;
			case 4:
				display(binarySearchTree.sort());
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("INVALID!!");
				break;
			}
		} while (choice != 0);

	}

}