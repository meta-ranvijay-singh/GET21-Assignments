package Algorithm2_Q2;

import static org.junit.Assert.*;

import org.junit.Test;

import Algorithm2_Q1.UndirectedWeightedGraph;

public class UndirectedListGraphTest {

	@Test
	public void test() {
		UndirectedListGraph graph=new UndirectedListGraph();
		
		graph.addEdge(2, 0, 4);
		graph.addEdge(1, 4, 1);
		graph.addEdge(1, 0, 2);
		graph.addEdge(4, 3, 1);
		graph.addEdge(3, 0, 3);
		
		assertTrue(graph.isConnected());
		
		assertArrayEquals(new int[]{3,1,2,-1,-1}, graph.reachable(0));
	}

}
