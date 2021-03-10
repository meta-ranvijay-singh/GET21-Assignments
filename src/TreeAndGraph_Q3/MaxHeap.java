package TreeAndGraph_Q3;

/*
 * Max Heap using array
 */
public class MaxHeap {
	private int[] Heap;
	private int size;
	private int capacity;

	public MaxHeap(int maxsize) {
		capacity = maxsize;
		this.size = 0;
		Heap = new int[capacity + 1];
		Heap[0] = Integer.MAX_VALUE;
	}

	/*
	 * Method to check for empty maxHeap
	 * @return true if maxHeap is empty otherwise false
	 */
	public boolean isEmpty(){
		if(size < 1){
			return true;
		}
		return false;
	}
	/* Method to position of parent node
	 * @return int position of parent
	 */
	private int parent(int pos) {
		return pos / 2;
	}

	/* Method to position of left child node
	 * @return int position of left child
	 */
	private int leftChild(int pos) {
		return (2 * pos);
	}

	/* Method to position of right child node
	 * @return int position of right child
	 */
	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	/* Method to check for leaf node
	 * @return true if the node is leaf otherwise false
	 */
	private boolean isLeaf(int pos) {
		if (pos > (size / 2)) {
			return true;
		}
		return false;
	}

	/* Method to swap the elements in the heap
	 */
	private void swap(int fpos, int spos) {
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	/* Recursive Method to heapify max heap in correct order
	 * it will check only down side form top to bottom
	 */
	private void maxHeapify(int pos) {
		if (isLeaf(pos))
			return;

		if (Heap[pos] < Heap[leftChild(pos)]
				|| Heap[pos] < Heap[rightChild(pos)]) {

			if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			} else {
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}

	/* Method to insert a new element
	 * @param int element
	 */
	public void insert(int element) {
		Heap[++size] = element;

		int current_position = size;
		//Loop for Traversing up and fix violated property
		while (Heap[current_position] > Heap[parent(current_position)]) {
			swap(current_position, parent(current_position));
			current_position = parent(current_position);
		}
	}

	/* Method to print element of the heap
	 */
	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : "
					+ Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
			System.out.println();
		}
	}

	/* Method to remove a element from the max heap 
	 * @return deleted element
	 */
	public int removeMaxHeap() {
		int deleted_element = Heap[1];
		Heap[1] = Heap[size--];
		maxHeapify(1);
		return deleted_element;
	}

}