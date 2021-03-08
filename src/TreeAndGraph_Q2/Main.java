package TreeAndGraph_Q2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Priority_Queue priority_Queue=new Priority_Queue(4);
		
		priority_Queue.Enqueue(5, 4);
		priority_Queue.Enqueue(7, 2);
		priority_Queue.Enqueue(8, 3);
		priority_Queue.Enqueue(10, 1);
		
		priority_Queue.Display();
	}

}
