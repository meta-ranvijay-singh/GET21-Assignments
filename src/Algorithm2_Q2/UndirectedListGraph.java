package Algorithm2_Q2;

import Algorithm2_Q1.UndirectedGraph;

public class UndirectedListGraph implements UndirectedGraph{

	class Node{
		int vertex;
		Node next;
		connectedNode edges;
		Node(int vertex){
			this.vertex=vertex;
			next=null;
			edges=null;
		}
		
	}
	
	class connectedNode{
		int vertex, weight;
		connectedNode next;
		connectedNode(int vertex, int weight){
			this.vertex=vertex;
			this.weight=weight;
			next=null;
		}
	}
	
	Node head=null;
	
	/*
	 * Method to add edges to the graph
	 * 
	 * @param source node, destination node and its weight
	 */
	public void addEdge(int source, int destination, int weight) {
		
		Node new_node=new Node(source);
		connectedNode new_edge=new connectedNode(destination, weight);
		
		if(head == null){
			new_node.edges=new_edge;
			head=new_node;
			
			new_node=new Node(destination);
			new_edge=new connectedNode(source, weight);
			
			new_node.edges=new_edge;
			new_node.next=head;
			head=new_node;
			
			return;
		}
		
		Node tempHead=head;
		
		while(tempHead != null){
			if(tempHead.vertex == source){
				new_edge.next=tempHead.edges;
				tempHead.edges=new_edge;	
				
				//---------
				new_node=new Node(destination);
				new_edge=new connectedNode(source, weight);
				

				tempHead=head;
				
				while(tempHead != null){
					if(tempHead.vertex == destination){
						new_edge.next=tempHead.edges;
						tempHead.edges=new_edge;		
						return;
					}
					tempHead=tempHead.next;
				}
				
				new_node.edges=new_edge;
				new_node.next=head;
				head=new_node;
				
				//--------
				return;
			}
			tempHead=tempHead.next;
		}
		
		new_node.edges=new_edge;
		new_node.next=head;
		head=new_node;
		
		new_node=new Node(destination);
		new_edge=new connectedNode(source, weight);
		

		tempHead=head;
		
		while(tempHead != null){
			if(tempHead.vertex == destination){
				new_edge.next=tempHead.edges;
				tempHead.edges=new_edge;		
				return;
			}
			tempHead=tempHead.next;
		}
		
		new_node.edges=new_edge;
		new_node.next=head;
		head=new_node;
				
	}
	
	 public void printGraph()  {
	        System.out.println("The contents of the graph:");
	        Node tempHead=head;

			while(tempHead != null){
				System.out.print("Vertex:" + tempHead.vertex );
				connectedNode tempEdge=tempHead.edges;
				while(tempEdge != null){
					System.out.print(" ==> " + tempEdge.vertex + 
                            " (" + tempEdge.weight + ")\t");
						tempEdge=tempEdge.next;
				}
	            System.out.println();
				tempHead=tempHead.next;
			}
			
	    }
	
	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reachable(int a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[][] mst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void shortestPath(int startNode, int endNode) {
		// TODO Auto-generated method stub
		
	}

}
