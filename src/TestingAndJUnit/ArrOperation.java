package TestingAndJUnit;

public class ArrOperation {
	
	
	public int maxMirror(int[] arr){
        int temp,max,count;
        temp=max=count=0;
        
        for(int i=0; i<arr.length; ++i){
        	count=0;
        	temp=i;
        	for(int j=arr.length-1; j>=temp; --j){
        		  if(arr[temp] == arr[j]){
                    count++;
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

        return max;
 }
}
