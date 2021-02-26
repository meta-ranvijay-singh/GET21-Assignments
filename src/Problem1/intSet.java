package Problem1;

public final class intSet {
	private final int[] arr;
	
	public intSet(int[] a){
		arr=a;
	}
	
	private int[] getArray(){
		int[] temp =new int[arr.length];
		
		for(int i=0; i<temp.length; ++i){
			temp[i]=arr[i];
		}
		return temp;
	}
	
	public boolean isMember(int x){
		for(int i=0; i<arr.length; ++i){
			if(arr[i] == x){
				return true;
			}
		}
		
		return false;	
	}
	
	public int[] getComplement(){
		int[] complement=new int[1000-arr.length];
		for(int i=0, j=0; i<1000; ++i){
			if( !isMember(i+1)){
				complement[j]=i+1;
				++j;
			}
		}
		return complement;
	}
	
	public int[] union(intSet s1, intSet s2){
		int[] temp1=s1.getArray();
		int[] temp2=s2.getArray();
		
		
			int tempp[] = new int[s1.size()+s2.size()];
		int i=0;
		for(i=0; i<temp1.length; ++i){
			tempp[i]=temp1[i];
		}
		for(int j=0; j< temp2.length; ++j){
			if( !s1.isMember(temp2[j]) ){
				tempp[i]=temp2[j];
				++i;
			}
		}
		return tempp;
	}
	
	public boolean isSubSet(intSet s){
		int[] temp=s.getArray();
		for(int i=0; i<temp.length; ++i){
			if( !isMember(temp[i])){
				return false;
			}
		}
		return true;
	}
	
	public int size(){
		return arr.length;
	}
}
