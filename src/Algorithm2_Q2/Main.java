package Algorithm2_Q2;

public class Main {

		
	public static void main(String[] args) {
		
		UndirectedListGraph graph=new UndirectedListGraph();



		graph.addEdge(0 ,1, 2);
		graph.addEdge(0, 2, 4);
		graph.addEdge(3, 2, 3);
		graph.addEdge(4, 5, 1);
		graph.addEdge(1, 2, 4);

		graph.printGraph();

	}

}
