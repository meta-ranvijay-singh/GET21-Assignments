package TestingAndJUnit;

public class ArrOperation {
	
	/**
	 * Return the size of the largest mirror section found in the input array.
	 * @param arr int array
	 * @return max size of largest mirror section
	 */
	public int maxMirror(int[] arr){
        int temp,max,count;
        temp=max=count=0;
        if(arr.length == 0){
        	throw new AssertionError(true);
        }
        if(arr != null){
        	for(int i=0; i<arr.length; ++i){
            	count=0;
            	temp=i;
            	for(int j=arr.length-1; j>=temp; --j){
            		if(arr[temp] == arr[j]){ 
            			if(temp == (arr.length/2) ){
                     		count*=2;
                     	}
            			else{
                			 count++;
            			}
                        if(temp==j){
                        	count++;
                        }
                        temp++;
            		 }
            		 else if(count > 0){
            			  break;                
            		 }
            		 if(max < count){
            			  max=count;
            		 }
            	}
            }
        }
        return max;
        
//        [ 1,2,3,1,2,4,2,1 ]
//        		1,2
//        		1,2
//        		1,2,4
//        		1,2,4,2
//        		1,2,4,2,1
        		
        		
	}
	
	/**
	 * Return the number of clumps in the input array.
	 * @param arr int array
	 * @return count number of clumps in the input array
	 */
	public int countClumps(int[] arr){
  	  boolean found=false;
  	  int count = 0;
  	  if(arr.length == 0){
  		  throw new AssertionError(true);
  	  }
  	  if(arr != null){
  		for (int i = 0; i < arr.length-1; i++) {
  	  	    if (arr[i] == arr[i+1] && !found) {
  	  	    	found = true;
  	  	    	count++;
  	  	    }
  	  	    else if (arr[i] != arr[i+1]) {
  	  	    	found = false;
  	  	    }
  	  	  }
  	  }
  	  
  	  
  	  return count;
  	}
	
	/**
	 * Return an array that contains exactly the same numbers as the input array, but rearranged so 
	 * that every X is immediately followed by a Y.
	 * @param arr int array, X and Y int
	 * @return nums array having rearranged array that every X is immediately followed by a Y
	 */
	public int[] fixXY(int[] nums, int X, int Y)
	{
	  int j = 0;
	  
	  if(nums.length == 0 || nums[nums.length-1] == X){
      	throw new AssertionError(true);
      }
	  if(nums != null){
		for(int i = 0; i < nums.length - 1; i++)
		{
			if(nums[i+1] == X){
				throw new AssertionError(true);
			}
			if(nums[i] == X && nums[i+1] != Y && nums[i+1] != X)
			{
				while (nums[j] != Y || (j != 0 && nums[j - 1] == X)) {
		            j++;
		        }
				nums[j] = nums[i+1];
				nums[i+1] = Y;
			}
		}
	  }
	return nums;
	}
	
	/**
	 * Return the index if there is a place to split the input array so that the sum of the numbers on
	 * one side is equal to the sum of the numbers on the other side
	 * @param arr int array
	 * @return index int else -1
	 */
	public int splitArray(int[] arr){
		int index=-1,sum=0;

		if(arr.length == 0){
        	throw new AssertionError(true);
        }
		if(arr != null){
			for(int i=0; i<arr.length-1; ++i){
				sum+=arr[i];
				int nextSum=0;
				for(int j=i+1; j<arr.length; ++j){
					nextSum+=arr[j];
				}
				if(nextSum == sum){
					index=i+1;
					break;
				}
			}
		}
		
		return index;
	}

}
