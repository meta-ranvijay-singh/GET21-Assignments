package Recursion_Q2;

public class Search {
	
	/**
	 * Linear Search method
	 * @param arr array of integers, num value to be search
	 * @return if found return index else -1
	 */
	public int LinearSearch(int[] arr, int num){
		if(arr.length <= 0)
			throw new AssertionError(true);
		int index=0;
		return findLinear(arr, index, num);
	}
	
	/**
	 * Binary Search method
	 * @param arr array of integers, num value to be search
	 * @return if found return index else -1
	 */
	public int BinarySearch(int[] arr, int num){
		if(arr.length <= 0)
			throw new AssertionError(true);
		int start=0, end=arr.length-1;
		return findBinary(arr, start,end, num);
	}
	
	/**
	 * Recursive method to implement Linear Search
	 * @param arr array of integers, index of array, val value to be search
	 * @return if found return index else -1
	 */
	private int findLinear(int[] arr, int index, int val){
		if(index >= arr.length)
			return -1;
		if(arr[index] == val){
			return index;
		}
		else{
			return findLinear(arr, index+1, val);
		}
	}
	
	/**
	 * Recursive method to implement Binary Search
	 * @param arr array of integers, start starting index of sub-array,
	 * end ending index of sub-array, val value to be search
	 * @return if found return index else -1
	 */
	private int findBinary(int arr[], int start, int end, int val){
	      if (end >= start){
	         int mid = start + (end - start) / 2;
	         if (arr[mid] == val)
	         return mid;
	         if (arr[mid] > val)
	         return findBinary(arr, start, mid-1, val);
	         return findBinary(arr, mid+1, end, val);
	      }
	      return -1;
	   }
}
