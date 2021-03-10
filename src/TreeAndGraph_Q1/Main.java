package TreeAndGraph_Q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		TreeDirectory treeDirectory = new TreeDirectory();
		String directoryName;
		String input[];

		directoryName = "R:\\";

		System.out.println("Welcome to virtual command prompt!!!");

		do {
			System.out.print(directoryName + ">");
			input = in.nextLine().split(" ");

			switch (input[0]) {
			case "mkdir":
				if (!input[1].equals("") || !input[1].equals(" ")) {
					if (treeDirectory.findDirectory(treeDirectory.current_node,
							input[1])) {
						System.out.println("Folder name already present..");
					} else {
						treeDirectory.makeDirectory(input[1]);
					}

				} else {
					System.out.println("Enter valid directory name.");
				}

				break;
			case "cd":
				String changedDir = treeDirectory.changeDirectory(input[1]);
				if (!changedDir.equals("null")) {
					directoryName = directoryName + "\\" + changedDir;
				} else {
					System.out.println("Directory not found.");
				}
				break;
			case "bk":
				if (treeDirectory.back()) {
					int lastIndex = directoryName.lastIndexOf("\\");
					directoryName = directoryName.substring(0, lastIndex);
				}

				break;
			case "ls":
				treeDirectory.listOfFolder();
				break;
			case "find":
				if (treeDirectory.findDirectory(treeDirectory.current_node,
						input[1])) {
					System.out.println(input[1]
							+ " is founded in current directory.");
				} else {
					System.out.println(input[1]
							+ " is not founded in current directory.");
				}
				break;
			case "tree":
				treeDirectory.displayTree(treeDirectory.root, 0);
				;
				break;
			default:
				break;
			}
		} while (!input[0].equals("exit"));

		

	}

}
