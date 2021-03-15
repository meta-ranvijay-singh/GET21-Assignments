package Algorithm2_Q2;

import Algorithm2_Q1.UndirectedGraph;

public class UndirectedListGraph implements UndirectedGraph {

	class Node {
		int vertex;
		Node next;
		connectedNode edges;

		Node(int vertex) {
			this.vertex = vertex;
			next = null;
			edges = null;
		}

	}

	class connectedNode {
		int vertex, weight;
		connectedNode next;

		connectedNode(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
			next = null;
		}
	}

	Node head = null;

	/*
	 * Method to add edges to the graph
	 * 
	 * @param source node, destination node and its weight
	 */
	public void addEdge(int source, int destination, int weight) {

		Node new_node = new Node(source);
		connectedNode new_edge = new connectedNode(destination, weight);

		if (head == null) {
			// Adding edges between source to destination
			new_node.edges = new_edge;
			head = new_node;

			new_node = new Node(destination);
			new_edge = new connectedNode(source, weight);

			// Adding edges between destination to source
			new_node.edges = new_edge;
			new_node.next = head;
			head = new_node;

			return;
		}

		Node tempHead = head;

		while (tempHead != null) {
			// if vertex is already in the list
			if (tempHead.vertex == source) {
				// Adding edges between source to destination
				new_edge.next = tempHead.edges;
				tempHead.edges = new_edge;

				// Adding edges between destination to source
				new_node = new Node(destination);
				new_edge = new connectedNode(source, weight);

				tempHead = head;

				while (tempHead != null) {
					if (tempHead.vertex == destination) {
						new_edge.next = tempHead.edges;
						tempHead.edges = new_edge;
						return;
					}
					tempHead = tempHead.next;
				}

				new_node.edges = new_edge;
				new_node.next = head;
				head = new_node;

				// --------
				return;
			}
			tempHead = tempHead.next;
		}

		// if vertex is not in the list
		// Adding edges between source to destination
		new_node.edges = new_edge;
		new_node.next = head;
		head = new_node;

		new_node = new Node(destination);
		new_edge = new connectedNode(source, weight);

		tempHead = head;

		// Adding edges between destination to source
		// Checking destination vertex is already in the list or not
		while (tempHead != null) {
			// If destination vertex is already in the list
			if (tempHead.vertex == destination) {
				new_edge.next = tempHead.edges;
				tempHead.edges = new_edge;
				return;
			}
			tempHead = tempHead.next;
		}
		// If destination vertex is not in the list
		new_node.edges = new_edge;
		new_node.next = head;
		head = new_node;

	}

	/*
	 * Method to print adjacency matrix of the graph
	 */
	public void printGraph() {
		System.out.println("The contents of the graph:");
		Node tempHead = head;

		while (tempHead != null) {
			System.out.print("Vertex:" + tempHead.vertex);
			connectedNode tempEdge = tempHead.edges;
			while (tempEdge != null) {
				System.out.print(" ==> " + tempEdge.vertex + " ("
						+ tempEdge.weight + ")\t");
				tempEdge = tempEdge.next;
			}
			System.out.println();
			tempHead = tempHead.next;
		}

	}

	/*
	 * Method to check graph is connected or not
	 * 
	 * @return true if graph is connected otherwise false
	 */
	@Override
	public boolean isConnected() {
		Node tempHead = head;
		int vertex = 0;
		while (tempHead != null) {
			++vertex;
			tempHead = tempHead.next;
		}
		boolean visited[] = new boolean[vertex];
		tempHead = head;
		// call recursive DFS_helper function for DFS technique
		DFS(tempHead, visited);

		for (int i = 0; i < vertex; ++i) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Support method for isConnected() for depth first search
	 * 
	 * @param start node and visitedList
	 */
	void DFS(Node tempHead, boolean visited[]) {
		// current node is visited
		if (tempHead == null) {
			return;
		}
		visited[tempHead.vertex] = true;
		connectedNode edges = tempHead.edges;
		while (edges != null) {
			if (!visited[edges.vertex]) {
				Node temp = head;
				while (temp != null) {
					if (temp.vertex == edges.vertex) {
						break;
					}
					temp = temp.next;
				}
				DFS(temp, visited);
			}
			edges = edges.next;
		}
	}

	/*
	 * Method to print all the connected vertex to given vertex
	 * 
	 * @param vertex
	 */
	@Override
	public int[] reachable(int vertex) {
		Node tempHead = head;
		int numOfNodes=0;
		while(tempHead != null){
			++numOfNodes;
			tempHead=tempHead.next;
		}
		int[] reachableNode=new int[numOfNodes];

		int i=0;
		for(i=0; i<numOfNodes; ++i){
			reachableNode[i]= -1;
		}
		i=0;
		tempHead = head;
		while (tempHead != null) {
			if (tempHead.vertex == vertex) {
				connectedNode edges = tempHead.edges;
				while (edges != null) {
					//System.out.print(edges.vertex + " ");
					reachableNode[i++]=edges.vertex;
					edges = edges.next;
				}
				break;
			}
			tempHead = tempHead.next;
		}
		
		return reachableNode;

	}

	/*
	 * Method to get minimum spanning tree
	 * 
	 * @return int[][] 2D-array having vertex and shortest distance
	 */
	@Override
	public int[][] mst() {
		boolean[] mst = new boolean[5];
		int[][] resultSet = new int[5][5];
		int[] weight = new int[5];

		int numOfVertex = 0;
		Node tempHead = head;
		while (tempHead != null) {
			++numOfVertex;
			tempHead = tempHead.next;
		}
		/*
		 * Initialize all the weight to infinity and initialize resultSet for
		 * all the vertices
		 */
		for (int i = 0; i < numOfVertex; i++) {
			weight[i] = Integer.MAX_VALUE;
		}

		weight[0] = 0;
		resultSet[0][0] = -1;

		// Creating Minimum Spanning Tree
		for (int i = 0; i < numOfVertex; i++) {

			// get the vertex with the minimum weight
			int vertex = getMinimumVertex(mst, weight, numOfVertex);

			// include this vertex in MST
			mst[vertex] = true;

			/*
			 * iterate through all the adjacent vertices of above vertex and
			 * update the weight
			 */

			tempHead = head;
			while (tempHead != null) {
				if (tempHead.vertex == vertex) {
					break;
				}
				tempHead = tempHead.next;
			}
			connectedNode edges = tempHead.edges;
			while (edges != null) {
				if (mst[edges.vertex] == false
						&& edges.weight < weight[edges.vertex]) {
					weight[edges.vertex] = edges.weight;
					resultSet[edges.vertex][0] = tempHead.vertex;
					resultSet[edges.vertex][1] = edges.weight;
				}
				edges = edges.next;
			}
		}
		return resultSet;
	}

	/*
	 * Support method for mst() to find minimum weight vertex
	 */
	private int getMinimumVertex(boolean[] mst, int[] weight, int numOfVertex) {
		int minWeight = Integer.MAX_VALUE;
		int vertex = -1;
		for (int i = 0; i < numOfVertex; i++) {

			if (mst[i] == false && minWeight > weight[i]) {
				minWeight = weight[i];
				vertex = i;
			}
		}
		return vertex;
	}

	/*
	 * Method to print shortest path between start node to end node
	 * 
	 * @param startNode and endNode
	 */
	@Override
	public void shortestPath(int startNode, int endNode) {
		dijkstraAlgo(startNode, endNode);
	}

	/*
	 * Method to implement Dijkstra Algorithm
	 * 
	 * @param start vertex and end vertex
	 */
	private void dijkstraAlgo(int startVertex, int endVertex) {
		int numOfvertices = 0;
		Node tempHead = head;
		while (tempHead != null) {
			++numOfvertices;
			tempHead = tempHead.next;
		}
		/*
		 * shortestDistances[i] will hold the shortest distance from startVertex
		 * to i
		 */
		int[] shortestDistances = new int[numOfvertices];

		/*
		 * added[i] will true if vertex i is included / in shortest path tree or
		 * shortest distance from src to i is finalized
		 */
		boolean[] added = new boolean[numOfvertices];

		/*
		 * Initialize all distances as INFINITE and added[] as false
		 */
		for (int i = 0; i < numOfvertices; i++) {
			shortestDistances[i] = Integer.MAX_VALUE;
			added[i] = false;
		}

		shortestDistances[startVertex] = 0;

		// Parent array to store shortest path tree
		int[] parents = new int[numOfvertices];

		// The starting vertex does not have a parent
		parents[startVertex] = -1;

		// Loop for finding shortest path for all vertices
		for (int i = 1; i < numOfvertices; i++) {

			/*
			 * Pick the minimum distance vertex from the set of vertices not yet
			 * processed. nearestVertex is always equal to startNode in first
			 * iteration.
			 */
			int nearestVertex = -1;
			int shortestDistance = Integer.MAX_VALUE;
			for (int vertexIndex = 0; vertexIndex < numOfvertices; vertexIndex++) {
				if (!added[vertexIndex]
						&& shortestDistances[vertexIndex] < shortestDistance) {
					nearestVertex = vertexIndex;
					shortestDistance = shortestDistances[vertexIndex];
				}
			}

			// Mark the picked vertex as processed
			added[nearestVertex] = true;

			// Update dist value of the adjacent vertices of the picked vertex.
			tempHead = head;
			while (tempHead != null) {
				if (tempHead.vertex == nearestVertex) {
					break;
				}
				tempHead = tempHead.next;
			}

			connectedNode edges = tempHead.edges;
			while (edges != null) {
				int edgeDistance = edges.weight;
				if (edgeDistance > 0
						&& ((shortestDistance + edgeDistance) < shortestDistances[edges.vertex])) {
					parents[edges.vertex] = nearestVertex;
					shortestDistances[edges.vertex] = shortestDistance
							+ edgeDistance;
				}
				edges = edges.next;
			}
		}

		printPath(endVertex, parents);
	}

	/*
	 * Method to print shortest path from start to end vertex
	 * 
	 * @param end vertex and parents array stored shortest path
	 */
	private void printPath(int endVertex, int[] parents) {
		if (endVertex == -1) {
			return;
		}
		printPath(parents[endVertex], parents);
		System.out.print(endVertex + " ");
	}

}
