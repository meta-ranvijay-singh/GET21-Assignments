package Algorithm2_Q1;

public interface UndirectedGraph {
	public boolean isConnected();
	public int[] reachable(int node);
	public int[][] mst();
	public void shortestPath(int startNode, int endNode);
}
