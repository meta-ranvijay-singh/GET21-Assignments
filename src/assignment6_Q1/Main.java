package assignment6_Q1;

import java.util.Scanner;

public class Main {
	static Scanner in=new Scanner(System.in);
	
	public static SparseMatrix input(){
		System.out.println("Enter size of matrix (row x col) : ");
		int row1=in.nextInt();
		int col1=in.nextInt();		
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
		
		
//		int p[][]={{0,0,1}, {1,0,1}, {2,2,1}};
//		int p1[][]={{0,1,1}, {1,2,9}, {2,1,3}};
//		int row1=3,col1=3;
//		int row2=3,col2=3;
		
		int ch;
		SparseMatrix m1,m2;
		
		
		//SparseMatrix s2=new SparseMatrix(p1, row2, col2);
		do{
		
			menu();
			ch=in.nextInt();
			switch(ch){
			case 1:
				m1=input();
				System.out.println("Matrix :");
				m1.display();		
				System.out.println("\nTranspose of matrix : ");
				SparseMatrix s=m1.transpose();
				s.display();
				break;
			case 2:
				m1=input();
				System.out.println("Matrix :");
				m1.display();
				System.out.println("Symmetrical Matrix : "+m1.checkSymmetry());
				break;
			case 3:
				System.out.println("Enter matrix A :");
				m1=input();
				System.out.println("Enter matrix B :");
				m2=input();
				System.out.println("Result :");
				m1.add(m2);
				break;
			case 4:
				System.out.println("Enter matrix A :");
				m1=input();
				System.out.println("Enter matrix B :");
				m2=input();
				System.out.println("Result :");
				m1.multiply(m2);
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
