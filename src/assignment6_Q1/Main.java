package assignment6_Q1;

public class Main {

	public static void main(String[] args) {
		
		int p[][]={{0,0,1}, {1,0,1}, {2,2,1}};
		int p1[][]={{0,1,1}, {1,2,9}, {2,1,3}};
		int row1=3,col1=3;
		int row2=3,col2=3;
				
		SparseMatrix s1=new SparseMatrix(p, row1, col1);
		SparseMatrix s2=new SparseMatrix(p1, row2, col2);
		
		System.out.println("Matrix A:");
		s1.display();
		
		System.out.println("Matrix B:");
		s2.display();
		
		System.out.println("\nTranspose of matrix A: ");
		s1.display();
		System.out.println("Symmetrical Matrix : "+s1.checkSymmetry());
		
		System.out.println("\nTranspose of matrix B: ");
		s2.display();
		System.out.println("Symmetrical Matrix : "+s2.checkSymmetry());
		
		System.out.println("\nAddition of Matrix A and B : ");
		s1.add(s2);
		
		System.out.println("\nAddition of Matrix A and B : ");
		s1.multiply(s2);
	}

}
