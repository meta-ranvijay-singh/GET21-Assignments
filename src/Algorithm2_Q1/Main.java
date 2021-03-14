package Algorithm2_Q1;

import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void printMST(int[][] resultSet) {
		int total_min_weight = 0;
		System.out.println("Minimum Spanning Tree: ");
		for (int i = 1; i < resultSet.length; i++) {
			System.out.println("Edge: " + i + " - " + resultSet[i][0]
					+ " key: " + resultSet[i][1]);
			total_min_weight += resultSet[i][1];
		}
		System.out.println("Total minimum key: " + total_min_weight);
	}

	public static void menu() {
		System.out.println("\n-------MENU----------");
		System.out.println("1. Add edge");
		System.out.println("2. isConnected graph");
		System.out.println("3. Find all reachable node of a specific node");
		System.out.println("4. Find MST of the graph");
		System.out.println("5. Find shortest path between two nodes");
		System.out.println("6. Display adjacency matrix");
		System.out.println("0. Exit");
		System.out.print("Enter :");
	}

	public static void main(String[] args) {

		System.out.print("Enter the number of nodes :");
		int num_of_nodes = in.nextInt();

		UndirectedWeightedGraph graph = new UndirectedWeightedGraph(
				num_of_nodes);
		int choice, source, destination, weight;
		do {
			menu();
			choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter source node :");
				source = in.nextInt();
				System.out.print("Enter destination node :");
				destination = in.nextInt();
				System.out.print("Enter weight :");
				weight = in.nextInt();

				graph.addEdge(source, destination, weight);
				break;
			case 2:
				System.out.println("Connected graph :" + graph.isConnected());
				break;
			case 3:
				System.out.print("Enter node number :");
				int node = in.nextInt();
				graph.reachable(node);
				break;
			case 4:
				printMST(graph.mst());
				break;
			case 5:
				System.out.print("Enter source node :");
				source = in.nextInt();
				System.out.print("Enter destination node :");
				destination = in.nextInt();
				graph.shortestPath(source, destination);
				break;
			case 6:
				graph.printMatrix();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("INVALID");
				break;
			}

		} while (choice != 0);
	}
}
