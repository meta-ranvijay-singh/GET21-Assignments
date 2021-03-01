package Specification_Q1;

public class stringOperation {

	/**
	 * Compare two strings.
	 * @param two strings for comparison str1 and str2
	 * @return 1 if equals else 0
	 */
	public int compareStrings(String str1, String str2){
		char[] arr1=str1.toCharArray();
		char[] arr2=str2.toCharArray();
		
		if(arr1.length != arr2.length){
			return 0;
		}
		else{
			for(int i=0; i<arr1.length; ++i){
				if(arr1[i] != arr2[i]){
					return 0;
				}
			}
		}
		return 1;
	}
	
	/**
	 * Reverse the input string.
	 * @param str string to be reverse
	 * @return reversed string
	 */
	public String reverseString(String str){
		char[] arr=str.toCharArray();
		for(int i=0,j=arr.length-1; i<j; ++i,--j){
			char temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			
		}		
		return String.valueOf(arr);
		
	}

	/**
	 * Replace lowercase characters with uppercase and vice-versa.
	 * @param str string to be reverse their case
	 * @return reversed case string
	 */
	public String reverseCase(String str){
		char[] arr=str.toCharArray();
		for(int i=0; i<arr.length; ++i){
			if(arr[i] <= 90 && arr[i] >= 65 ){
				arr[i]+=32;
			}
			else if(arr[i] <= 122 && arr[i] >= 97 ){
				arr[i]-=32;
			}
			
		}		
		return String.valueOf(arr);
	}
	
	/**
	 * Find largest word of the string.
	 * @param str string in which largest word is to be find
	 * @return largeWord the largest word. If two words are of same length then return last word
	 */
	public String largestWord(String str){
		str+=" ";
		char[] arr=str.toCharArray();
		int max=0,count=0;
		String large="",largeWord="";
		for(int i=0; i<arr.length; ++i){
			
			if(arr[i] != ' ' && arr[i] != '.' & arr[i] != ',' && arr[i] != '\''){
				++count;
				large+=arr[i];
			}
			else{
				if(max <= count){
					max=count;
					largeWord=large;
					
				}
				large="";
				count=0;
			}
		}
		return largeWord;
	}
}
