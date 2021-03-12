package Algorithm2_Q3;

/*
 * Linked List of Employee
 */
public class LinkedList {

	/*
	 * Employee Node
	 */
	class Node {
		Employees employee;
		Node next;

		Node(Employees employee) {
			this.employee = employee;
			next = null;
		}
	}

	public Node head;

	public LinkedList() {
		head = null;
	}

	/*
	 * Method to implement insertion sort
	 * 
	 * @param passedEmployee an Employee to insert
	 */
	void insert(Employees passedEmployee) {
		Node newnode = new Node(passedEmployee);

		if (head == null) {
			head = newnode;
			return;
		} 
		
		newnode.next = head;
		head = newnode;
		
	}

	/*
	 * Method to traverse node
	 */
	public void traverse() {
		Node tempHead = head;
		while (tempHead != null) {
			System.out.println(tempHead.employee);
			tempHead = tempHead.next;
		}
	}
	
	 Node paritionLast(Node start, Node end)
	    {
	        if (start == end || start == null || end == null)
	            return start;
	 
	        Node pivot_prev = start;
	        Node curr = start;
	        Employees pivot = end.employee;
	 
	        // iterate till one before the end,
	        // no need to iterate till the end
	        // because end is pivot
	        while (start != end) {
	            if (start.employee.compareTo(pivot) < 1 ) {
	                // keep tracks of last modified item
	                pivot_prev = curr;
	                Employees temp = curr.employee;
	                curr.employee = start.employee;
	                start.employee = temp;
	                curr = curr.next;
	            }
	            start = start.next;
	        }
	 
	        // swap the position of curr i.e.
	        // next suitable index and pivot
	        Employees temp = curr.employee;
	        curr.employee = pivot;
	        end.employee = temp;
	 
	        // return one previous to current
	        // because current is now pointing to pivot
	        return pivot_prev;
	    }
	 
	   public void sort(Node start, Node end)
	    {
	        if(start == null || start == end|| start == end.next )
	            return;
	 
	        // split list and partion recurse
	        Node pivot_prev = paritionLast(start, end);
	        sort(start, pivot_prev);
	 
	        // if pivot is picked and moved to the start,
	        // that means start and pivot is same
	        // so pick from next of pivot
	        if (pivot_prev != null && pivot_prev == start)
	            sort(pivot_prev.next, end);
	 
	        // if pivot is in between of the list,
	        // start from next of pivot,
	        // since we have pivot_prev, so we move two nodes
	        else if (pivot_prev != null
	                 && pivot_prev.next != null)
	            sort(pivot_prev.next.next, end);
	    }
}