package Algorithm2_Q1;

public interface UndirectedGraph {
	public boolean isConnected();
	public void reachable(int node);
	public int[][] mst();
	public void shortestPath(int startNode, int endNode);
}
