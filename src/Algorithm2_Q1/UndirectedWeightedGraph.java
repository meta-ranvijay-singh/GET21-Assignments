package Algorithm2_Q1;

public class UndirectedWeightedGraph implements UndirectedGraph {

	private int numOfNodes;
	private int[][] matrix;

	public UndirectedWeightedGraph(int numOfNodes) {
		this.numOfNodes = numOfNodes;
		matrix = new int[numOfNodes][numOfNodes];
	}

	/*
	 * Method to add edges to the graph
	 * 
	 * @param source node, destination node and its weight
	 */
	public void addEdge(int source, int destination, int weight) {
		int valueToAdd = weight;
		matrix[source][destination] = valueToAdd;
		matrix[destination][source] = valueToAdd;

	}

	/*
	 * Method to print adjacency matrix of the graph
	 */
	public void printMatrix() {
		for (int i = 0; i < numOfNodes; i++) {
			for (int j = 0; j < numOfNodes; j++) {
				System.out.printf("%5d", matrix[i][j]);
			}
			System.out.println();
		}
	}

	/*
	 * Method to check graph is connected or not
	 * 
	 * @return true if graph is connected otherwise false
	 */
	@Override
	public boolean isConnected() {
		boolean[] visited = new boolean[numOfNodes];
		DFS(0, visited);

		for (int i = 0; i < numOfNodes; ++i) {
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
	private void DFS(int startingNode, boolean[] visitedList) {
		visitedList[startingNode] = true;

		for (int i = 0; i < numOfNodes; ++i) {
			if (matrix[startingNode][i] > 0) {
				if (!visitedList[i])
					DFS(i, visitedList);
			}
		}
	}

	/*
	 * Method to print all the connected node to given node
	 * 
	 * @param node
	 */
	@Override
	public int[] reachable(int node) {
		int[] reachableNode=new int[numOfNodes];

		int i=0;
		for(i=0; i<numOfNodes; ++i){
			reachableNode[i]= -1;
		}
		i=0;
		for (int j = 0; j < numOfNodes; j++) {
			if (matrix[node][j] > 0) {
				reachableNode[i]=j;
				++i;
			}
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
		boolean[] mst = new boolean[numOfNodes];
		int[][] resultSet = new int[numOfNodes][numOfNodes];
		int[] weight = new int[numOfNodes];

		/*
		 * Initialize all the weight to infinity and initialize resultSet for
		 * all the vertices
		 */
		for (int i = 0; i < numOfNodes; i++) {
			weight[i] = Integer.MAX_VALUE;
		}

		weight[0] = 0;
		resultSet[0][0] = -1;

		// Creating Minimum Spanning Tree
		for (int i = 0; i < numOfNodes; i++) {

			// get the vertex with the minimum weight
			int vertex = getMinimumVertex(mst, weight);

			// include this vertex in MST
			mst[vertex] = true;

			/*
			 * iterate through all the adjacent vertices of above vertex and
			 * update the weight
			 */
			for (int j = 0; j < numOfNodes; j++) {
				// check of the edge
				if (matrix[vertex][j] > 0) {
					/*
					 * check if this vertex 'j' already in mst and if no then
					 * check if key needs an update or not
					 */
					if (mst[j] == false && matrix[vertex][j] < weight[j]) {
						weight[j] = matrix[vertex][j];
						resultSet[j][0] = vertex;
						resultSet[j][1] = weight[j];
					}
				}
			}
		}
		return resultSet;
	}

	/*
	 * Support method for mst() to find minimum weight vertex
	 */
	private int getMinimumVertex(boolean[] mst, int[] weight) {
		int minWeight = Integer.MAX_VALUE;
		int vertex = -1;
		for (int i = 0; i < numOfNodes; i++) {

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
		dijkstraAlgo(matrix, startNode, endNode);
	}

	/*
	 * Method to implement Dijkstra Algorithm
	 * 
	 * @param adjaceny matrix , start vertex and end vertex
	 */
	private void dijkstraAlgo(int[][] adjacencyMatrix, int startVertex,
			int endVertex) {
		int vertices = adjacencyMatrix[0].length;

		/*
		 * shortestDistances[i] will hold the shortest distance from startVertex
		 * to i
		 */
		int[] shortestDistances = new int[vertices];

		/*
		 * added[i] will true if vertex i is included / in shortest path tree or
		 * shortest distance from src to i is finalized
		 */
		boolean[] added = new boolean[vertices];

		/*
		 * Initialize all distances as INFINITE and added[] as false
		 */
		for (int i = 0; i < vertices; i++) {
			shortestDistances[i] = Integer.MAX_VALUE;
			added[i] = false;
		}

		shortestDistances[startVertex] = 0;

		// Parent array to store shortest path tree
		int[] parents = new int[vertices];

		// The starting vertex does not have a parent
		parents[startVertex] = -1;

		// Loop for finding shortest path for all vertices
		for (int i = 1; i < vertices; i++) {

			/*
			 * Pick the minimum distance vertex from the set of vertices not yet
			 * processed. nearestVertex is always equal to startNode in first
			 * iteration.
			 */
			int nearestVertex = -1;
			int shortestDistance = Integer.MAX_VALUE;
			for (int vertexIndex = 0; vertexIndex < vertices; vertexIndex++) {
				if (!added[vertexIndex]
						&& shortestDistances[vertexIndex] < shortestDistance) {
					nearestVertex = vertexIndex;
					shortestDistance = shortestDistances[vertexIndex];
				}
			}

			// Mark the picked vertex as processed
			added[nearestVertex] = true;

			// Update dist value of the adjacent vertices of the picked vertex.
			for (int vertexIndex = 0; vertexIndex < vertices; vertexIndex++) {
				int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

				if (edgeDistance > 0
						&& ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
					parents[vertexIndex] = nearestVertex;
					shortestDistances[vertexIndex] = shortestDistance
							+ edgeDistance;
				}
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
