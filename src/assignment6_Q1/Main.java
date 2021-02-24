package assignment6_Q1;

import java.util.Scanner;

public class Main {
	static Scanner in=new Scanner(System.in);
	
	public static SparseMatrix input(int row1, int col1){
		System.out.println("Enter no. of non zero terms : ");
		int term=in.nextInt();
		int mat[][]=new int[term][3];
		
		System.out.println("Enter position(row col) and non zero value: ");
		for(int i=0; i<term; i++){
			mat[i][0]=in.nextInt();
			mat[i][1]=in.nextInt();
			mat[i][2]=in.nextInt();
		}
		SparseMatrix s=new SparseMatrix(mat, row1, col1);
		return s;
	}
	
	public static void menu(){
		System.out.println("-------MENU---------");
		System.out.println("1. Transpose");
		System.out.println("2. Check Symmetricity");
		System.out.println("3. Add two matrices");
		System.out.println("4. Multiply two matrices");
		System.out.println("0. Exit");
		System.out.println("Enter your choice : ");
	}
	public static void main(String[] args) {
		int ch,p,q,m,n;
		SparseMatrix m1,m2;
		
		do{
		
			menu();
			ch=in.nextInt();
			switch(ch){
			case 1:
				System.out.println("Enter size of matrix (row x col) : ");
				m=in.nextInt();
				n=in.nextInt();
				
				m1=input(m,n);
				System.out.println("Matrix :");
				m1.display();		
				System.out.println("\nTranspose of matrix : ");
				SparseMatrix s=m1.transpose();
				s.display();
				break;
			case 2:
				System.out.println("Enter size of matrix (row x col) : ");
				m=in.nextInt();
				n=in.nextInt();
				if(m == n){
					m1=input(m,n);
					System.out.println("Matrix :");
					m1.display();
					System.out.println("Symmetrical Matrix : "+m1.checkSymmetry());
				}
				else{
					System.out.println("Symmetrical Matrix : false");
				}
				
				break;
			case 3:
				System.out.println("Enter size of matrix A (row x col) : ");
				m=in.nextInt();
				n=in.nextInt();		
				m1=input(m,n);
				
				System.out.println("Enter size of matrix B (row x col) : ");
				p=in.nextInt();
				q=in.nextInt();		
				if(m == p && n == q){
					m2=input(p,q);
					System.out.println("Result :");
					SparseMatrix res=m1.add(m2);
					res.display();
				}
				else{
					System.out.println("Matrices can't be added.");
				}
				break;
			case 4:
				System.out.println("Enter size of matrix A (row x col) : ");
				m=in.nextInt();
				n=in.nextInt();		
				m1=input(m,n);
				
				System.out.println("Enter size of matrix B (row x col) : ");
				p=in.nextInt();
				q=in.nextInt();	
				
				if(n == p){
					m2=input(p,q);
					System.out.println("Result :");
					int C[][]=m1.multiply(m2);
					
					for(int i=0; i<m; ++i){
				    	 for (int j = 0; j < q; j++) { 
				    		 System.out.print(C[i][j]+" ");
				         }
				    	 System.out.println();
				     }
					
				}
				else{
					System.out.println("\nMultiplication Not Possible"); 
				}
				
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("INVALID!! choice.");
				break;
			}
			
		}while(ch != 0);
		
		
		
	}

}
