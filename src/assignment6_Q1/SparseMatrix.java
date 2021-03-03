package assignment6_Q1;

public class SparseMatrix {
	public final int[][] pos;
	private final int row,col;
	
	public SparseMatrix(int[][] position, int no_of_row, int no_of_col){
		int [][] temp=new int[position.length][3];
		
		for(int i=0; i<position.length; ++i){
			for(int j=0; j<3; ++j){
				temp[i][j]=position[i][j];
			}
		}
		
		pos=temp;
		row=no_of_row;
		col=no_of_col;
	}
	
	private int[][] getPos(){
		int tempPos[][]=new int[pos.length][3];

		for(int i=0; i<pos.length; ++i){		
			tempPos[i][0]=pos[i][0];
			tempPos[i][1]=pos[i][1];
			tempPos[i][2]=pos[i][2];
		}

		return tempPos;
	}
	
	private int getRow(){
		return row;
	}
	
	private int getCol(){
		return col;
	}
	
	public SparseMatrix transpose(){
		int tempPos[][]=getPos();

		for(int i=0; i<pos.length; ++i){
			int temp=tempPos[i][0];
			tempPos[i][0]=tempPos[i][1];
			tempPos[i][1]=temp;
		}
		
		SparseMatrix transposeMatrix=new SparseMatrix(tempPos, col, row);
		return transposeMatrix;
	}
	
	private int[][] matrix(int[][] position, int m, int n){
		int temp[][]=new int[m][n];
		for(int i=0; i<position.length; ++i){
			temp[position[i][0]][position[i][1]]=position[i][2];
		}
		return temp;
	}
	
	public boolean checkSymmetry(){
		SparseMatrix transposeMatrix=transpose();
		int transposePos[][]=transposeMatrix.getPos();
		boolean found=false;
		
		for(int i=0; i<pos.length; ++i){
			for(int j=0; j<transposePos.length; ++j){
				if(pos[i][0] == transposePos[j][0]){
					if(pos[i][1] == transposePos[j][1]){
						if(pos[i][2] == transposePos[j][2]){
							found=true;
							break;
						}
					}
				}
			}
			if(!found){
				return false;
			}
		}
		
		return true;
	}
	
	
	public SparseMatrix add(SparseMatrix sparseMatrixPassed){
		SparseMatrix result;
			int[][] temp=sparseMatrixPassed.getPos();
			int[][] res=new int[pos.length+temp.length][3];
			
			for(int i=0; i<pos.length; ++i){
				boolean found=false;
				for(int j=0; j<temp.length; ++j){
					if(pos[i][0] == temp[j][0]){
						if(pos[i][1] == temp[j][1]){
							res[i][0]=pos[i][0];
							res[i][1]=pos[i][1];
							res[i][2]=pos[i][2] + temp[j][2];
							temp[j][0]= -1;
							found=true;
							break;
						}
					}		
				}
				if(!found){
					res[i][0]=pos[i][0];
					res[i][1]=pos[i][1];
					res[i][2]=pos[i][2];
				}
			}

			for(int i=0, j=pos.length; i<temp.length; ++i){
				if(temp[i][0] != -1){
					res[j][0]=temp[i][0];
					res[j][1]=temp[i][1];
					res[j++][2]=temp[i][2];
				}
			}
			
			 result=new SparseMatrix(res, row, col);
			return result;
		
	}
	 public int[][] multiply(SparseMatrix sparseMatrixPassed){
		 if(sparseMatrixPassed.getPos().length <= 0){
			 throw new AssertionError();
		 }
		 int[][] mat1= matrix(pos, row, col);
		 int[][] mat2=sparseMatrixPassed.matrix(sparseMatrixPassed.getPos(), sparseMatrixPassed.getRow(), sparseMatrixPassed.getCol());
		 
		 int result[][] = new int[row][sparseMatrixPassed.getCol()]; 
	     for (int i = 0; i < row; i++) { 
	    	 for (int j = 0; j < sparseMatrixPassed.getCol(); j++) { 
	    		 for (int k = 0; k < sparseMatrixPassed.getRow(); k++) 
	    			 result[i][j] += mat1[i][k] * mat2[k][j]; 
	         } 
	     }
	     
	     return result;
		 
	 }
	public void display(){
		int temp[][]=new int[row][col];
		
		for(int i=0; i<pos.length; ++i){
			if(pos[i][2] != 0)
			temp[pos[i][0]][pos[i][1]]=pos[i][2];
		}
		
		for(int i=0; i<row; ++i){
			for(int j=0; j<col; ++j){
				System.out.print(temp[i][j] +" ");
			}
			System.out.println();
		}
		
	}
}
