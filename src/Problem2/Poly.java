package Problem2;

public final class Poly {
	private final int[][] poly;
	
	public Poly(int[][] a){
		poly=a;
	}
	
	private int[][] getPoly(){
		int temp[][]=poly;
		return temp;
	}
	public double evaluate(float val){
		double sum=0;
		for(int i=0; i<poly.length; ++i){
			sum += (poly[i][0] * Math.pow(val, poly[i][1]));
			
		}

		return sum;
	}
	
	public int degree(){
		int max=poly[0][0];
		for(int i=0; i<poly.length; ++i){
			if(max < poly[i][1]){
				max=poly[i][1];
			}
		}
		
		return max;
	}
	
	public Poly addPoly(Poly p1, Poly p2){
		Poly p;
		int temp1[][]=p1.getPoly();
		int temp2[][]=p2.getPoly();
		int temp[][]=new int[temp1.length+temp2.length][2];
		
		for(int i=0; i<temp1.length; ++i){
			int sum=temp1[i][0];
			for(int j=0; j<temp2.length; ++j){
				if(temp2[j][1] == temp1[i][1]){
					sum += temp2[j][0];
					temp2=remove(temp2,j);
				}
			}
			temp[i][0]=sum;
			temp[i][1]=temp1[i][1];
		}

		for(int i=temp1.length, j=0; j<temp2.length; ++j,++i){
			
			temp[i][0]=temp2[j][0];
			temp[i][1]=temp2[j][1];
		}
		


		p=new Poly(temp);
		
		return p;
	}
	
	public Poly multiplyPoly(Poly p1, Poly p2){
		Poly p;
		int temp1[][]=p1.getPoly();
		int temp2[][]=p2.getPoly();
		int temp[][]=new int[temp1.length * temp2.length][2];
		
		int k=0;
			for(int i=0; i<temp1.length; ++i){
				
				for(int j=0; j<temp2.length; ++j){
					int val=temp1[i][0] * temp2[j][0];
					int pow=temp1[i][1] + temp2[j][1];
					boolean found=false;
					for(int index=0; index<temp.length && temp[index][0] != '\0'; ++index){
						if(temp[index][1] == (temp1[i][1] + temp2[j][1]) ){
							temp[index][0] += ( temp1[i][0] * temp2[j][0] );
							found=true;
							break;
						}
					}
					if(!found){
						temp[k][0]=val;
						temp[k][1]=pow;	
						++k;
					}
				}
				
			}
		
		p=new Poly(temp);
		return p;
	}
	
	public void display(){
		for(int i=0; i<poly.length && poly[i][0] !='\0'; ++i){
			System.out.print(poly[i][0] +"x^"+poly[i][1]+" ");
			if((i+1)<poly.length && poly[i+1][0] !='\0'){
				System.out.print("+ ");
			}
			
		}
		
	}
	private int[][] remove(int p[][], int index){
		int temp[][]=new int[p.length-1][2];
		
		for(int i=0,k=0; i<p.length; ++i){
			if(i == index){
				continue;
			}
			temp[k][0]=p[i][0];
			temp[k][1]=p[i][1];
			++k;
		}
		return temp;
	}
}
