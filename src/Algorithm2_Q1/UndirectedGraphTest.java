package Algorithm2_Q1;

import static org.junit.Assert.*;

import org.junit.Test;

public class UndirectedGraphTest {

	@Test
	public void test() {
		int numOfNodes=5;
		UndirectedWeightedGraph graph=new UndirectedWeightedGraph(numOfNodes);
		
		graph.addEdge(2, 0, 4);
		graph.addEdge(1, 4, 1);
		graph.addEdge(1, 0, 2);
		graph.addEdge(4, 3, 1);
		graph.addEdge(3, 0, 3);
		
		assertTrue(graph.isConnected());
		
		assertArrayEquals(new int[]{1,2,3,-1,-1}, graph.reachable(0));
	}

}
