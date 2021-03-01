package Recursion_Q1;

public class Mathematics {
  
	/**
	 * Recursive method to find LCM of two number
	 * @param n1 and n2 positive integers
	 * @return LCM of n1 and n2
	 */
	int findLCM(int n1,int n2) 
	{
		return (n1*n2)/findHCF(n1, n2);
		  
 	 }
	
	/**
	 * Recursive method to find HCF of two number
	 * @param n1 and n2 positive integers
	 * @return HCF of n1 and n2
	 */
	public int findHCF(int n1, int n2){
		if(n2 == 0){
			return n1;
		}
		return findHCF(n2, n1%n2);
	}
	
}
