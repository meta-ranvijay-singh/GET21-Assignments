package assignment6_Q1;

public class SparseMatrix {
	public final int[][] pos;
	private final int row,col;
	
	public SparseMatrix(int[][] p, int m, int n){
		pos=p;
		row=m;
		col=n;
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
		
		SparseMatrix s1=new SparseMatrix(tempPos, col, row);
		return s1;
	}
	
	private int[][] matrix(int[][] p, int m, int n){
		int temp[][]=new int[m][n];
		for(int i=0; i<p.length; ++i){
			temp[p[i][0]][p[i][1]]=p[i][2];
		}
		return temp;
	}
	
	public boolean checkSymmetry(){
		SparseMatrix s=transpose();
		int smat[][]=s.getPos();
		boolean found=false;
		
		for(int i=0; i<row; ++i){
			for(int j=0; j<smat.length; ++j){
				if(pos[i][0] == smat[j][0]){
					if(pos[i][1] == smat[j][1]){
						if(pos[i][2] == smat[j][2]){
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
	public void add(SparseMatrix s){
		if(row != s.getRow() || col != s.getCol()){
			System.out.println("Matrices can't be added.");
		}
		else{
			int[][] temp=s.getPos();
			int[][] res=new int[row+temp.length][col+temp.length];
			
			for(int i=0; i<row; ++i){
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

			for(int i=0, j=row; i<temp.length; ++i){
				if(temp[i][0] != -1){
					res[j][0]=temp[i][0];
					res[j][1]=temp[i][1];
					res[j++][2]=temp[i][2];
				}
			}
			
			SparseMatrix sm=new SparseMatrix(res, row, col);
			sm.display();
		}
	}
	 public void multiply(SparseMatrix s){
		 int[][] mat1= matrix(pos, row, col);
		 int[][] mat2=s.matrix(s.getPos(), s.getRow(), s.getCol());
		 
		 if (col != s.getRow()) { 
	            System.out.println("\nMultiplication Not Possible"); 
	            return; 
	     }
		 
	     int C[][] = new int[row][s.getCol()]; 
	     for (int i = 0; i < row; i++) { 
	    	 for (int j = 0; j < s.getCol(); j++) { 
	    		 for (int k = 0; k < s.getRow(); k++) 
	    			 C[i][j] += mat1[i][k] * mat2[k][j]; 
	         } 
	     }
	     
	     for(int i=0; i<row; ++i){
	    	 for (int j = 0; j < s.getCol(); j++) { 
	    		 System.out.print(C[i][j]+" ");
	         }
	    	 System.out.println();
	     }
		 
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
