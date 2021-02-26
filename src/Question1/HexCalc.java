package Question1;

public class HexCalc{
	int base_con;
	String num1,num2;
	
	public HexCalc(int n) {
		num1=num2="";
		base_con=n;
	}

	public void input(String hex1, String hex2){
		num1=hex1;
		num2=hex2;
	}
	public String getNum1(){
		return num1;
	}
	public String getNum2(){
		return num2;
	}
	public String add(){
		int dec1=hexToDecimal(num1);
		int dec2=hexToDecimal(num2);
		int res=dec1+dec2;
		return decimalToHex(res);
	}
	public String multiply(){
		int dec1=hexToDecimal(num1);
		int dec2=hexToDecimal(num2);
		int res=dec1*dec2;
		return decimalToHex(res);
	}
	public String subtract(){
		int dec1=hexToDecimal(num1);
		int dec2=hexToDecimal(num2);
		int res=dec1-dec2;
		return decimalToHex(res);
	}
	public String divide(){
		int dec1=hexToDecimal(num1);
		int dec2=hexToDecimal(num2);
		int res=dec1/dec2;
		return decimalToHex(res);
	}
	public int hexToDecimal(String hv){
		int base=1;
		int val=0;
		for(int i=hv.length()-1; i>=0; --i){
			if(hv.charAt(i) >= '0' && hv.charAt(i) <= '9'){
				val+=( (hv.charAt(i)-48)*base );
				base*=base_con;
			}
			else if(hv.charAt(i) >= 'A' && hv.charAt(i) <= 'F'){
				val+=( (hv.charAt(i)-55)*base );
				base*=base_con;
			}
		}
		return val;
	}
	public String decimalToHex(int dec){
		String str="";
		while(dec > 0){
			int temp=0;
			temp=dec%base_con;
			if(temp<10){
				str=((char)(temp+48))+str;
			}
			else{
				str=((char)(temp+55))+str;
			}
			dec/=base_con;
		}
		return str;
	}
	
	
	public boolean compareEquality(){
		if(num1.compareTo(num2) == 0){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean compareGreaterThan(){
		if(num1.length() > num2.length()){
			return true;
		}
		else{
			if(num1.compareTo(num2) > 0){
				return true;
			}
			else{
				return false;
			}
		
		}
	}
	public boolean compareLessThan(){
		if(num1.length() < num2.length()){
			return true;
		}
		else{
			if(num1.compareTo(num2) < 0){
				return true;
			}
			else{
				return false;
			}
		}
	}
}