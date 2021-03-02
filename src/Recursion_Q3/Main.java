package Recursion_Q3;

import java.util.Scanner;

public class Main {
	static Scanner in=new Scanner(System.in);
	
	/**
	 * Method to print chess board
	 * @param board NxN matrix representing chess board
	 */
	public static void printSolution(int board[][]) 
	{ 
		for (int i = 0; i < board.length; i++) { 
			for (int j = 0; j < board.length; j++) 
				System.out.print(" " + board[i][j] 
								+ " "); 
			System.out.println(); 
		} 
	} 
	
	public static void main(String[] args) {
	
		int startRow=0, dimensionOfMatrix;
		NQueen solveQueen=new NQueen();
		
		System.out.print("Enter dimension of square matrix :");
		dimensionOfMatrix=in.nextInt();
		int[][] board=new int[dimensionOfMatrix][dimensionOfMatrix];
		
		System.out.println("");
		if (solveQueen.nQueen(board, startRow, dimensionOfMatrix) == false) { 
			System.out.println("Solution does not exist");  
		} 
		else{
			printSolution(board);
		}

		
		
	}

}
