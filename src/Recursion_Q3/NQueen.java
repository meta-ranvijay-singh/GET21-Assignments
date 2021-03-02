package Recursion_Q3;

public class NQueen { 

	/**
	 * Method to check, Is there any Queen in row, column and diagonals
	 * @param board NxN matrix representing chess board, row no. of rows,
	 * 		col no. of column, dimensionOfMatrix
	 * @return true if there is no queen in row, column and diagonals
	 * 		otherwise return false.
	 */
	boolean isSafe(int board[][], int row, int col, int dimensionOfMatrix) 
	{ 
		//Loop for checking rows and columns
		for (int i = 0; i < col; i++) 
			if((board[row][i] == 1) || (board[i][col] == 1))
				return false;

		//Loop for diagonals
		for(int i=0; i<dimensionOfMatrix; i++)
	    {
	        for(int j=0; j<dimensionOfMatrix; j++)
	        {
	            if(((i+j) == (row+col)) || ((i-j) == (row-col)))
	            {
	                if(board[i][j] == 1)
	                    return false;
	            }
	        }
	    }

		return true; 
	} 

	/**
	 * Method to place queen at the position where no other queen can attack on them
	 * @param board NxN matrix representing chess board, dimensionOfMatrix
	 * @return true if there is a solution, otherwise return false.
	 */
	public boolean nQueen(int board[][], int startRow, int dimensionOfMatrix) 
	{ 
		if (startRow >= dimensionOfMatrix) 
			return true; 

		for (int i = 0; i < dimensionOfMatrix; i++) { 
			if (isSafe(board, i, startRow, dimensionOfMatrix)) { 
				board[i][startRow] = 1; 

				if (nQueen(board, startRow + 1, dimensionOfMatrix) == true) 
					return true; 

				board[i][startRow] = 0; 
			} 
		} 

		return false; 
	} 

}