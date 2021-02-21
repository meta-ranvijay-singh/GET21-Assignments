package Question1;


import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class Main {

	public static void menu () {
		System.out.println();
	    System.out.println("-------HexCalc-------");
	    System.out.println("1. Addition");
	    System.out.println("2. Subtraction");
	    System.out.println("3. Multiplication");
	    System.out.println("4. Division");
	    System.out.println("5. Hex to Decimal Conversion");
	    System.out.println("6. Decimal to Hex Conversion");
	    System.out.println("7. Compare for equality");
	    System.out.println("8. Compare for greater than");
	    System.out.println("9. Compare for less than");
	    System.out.println("0. Exit");
	    System.out.print("Enter Choice : ");
	    
	}
	public static void getUserInput(HexCalc h) {
		
	    Scanner in = new Scanner (System.in);
	    System.out.print("Enter two hex number : ");
        String hex1=in.next();
        String hex2=in.next();
        h.input(hex1,hex2);

	}
	public static void main(String[] args) {
		
		int num=16;
		String res="";
		HexCalc h=new HexCalc(num);
		Scanner in = new Scanner (System.in);
		int ch;
		do{
			menu();
			ch=in.nextInt();
			switch (ch) {
            case 1: 
                getUserInput(h);
                System.out.print("Ans : "+h.add());
                break;
            case 2:
                getUserInput(h);
                System.out.print("Ans : "+h.subtract());
                break;
            case 3:
                getUserInput(h);
            	System.out.print("Ans : "+h.multiply());
                break;
            case 4:
                getUserInput(h);
            	System.out.print("Ans : "+h.divide());
                break;
            case 5:
            	System.out.print("Enter Hexadecimal number : ");
            	String hex=in.next();
            	System.out.print("Equivalent decimal number : "+h.hexToDecimal(hex));
                break; 
            case 6:
            	System.out.print("Enter Decimal number : ");
            	int dec=in.nextInt();
            	System.out.print("Equivalent Hexadecimal number : "+h.decimalToHex(dec));
                break; 
            case 7:
            	getUserInput(h);
            	if(h.compareEquality()){
            		System.out.println(h.getNum1()+" is equal to "+h.getNum2());
            	}
            	else{
            		System.out.println(h.getNum1()+" is not equal to "+h.getNum2());
            	}
            	break; 
            case 8:
            	getUserInput(h);
            	if(h.compareGreaterThan()){
            		System.out.println(h.getNum1()+" is greater than "+h.getNum2());
            	}
            	else{
            		System.out.println(h.getNum1()+" is not greater than "+h.getNum2());
            	}
                break; 
            case 9:
            	getUserInput(h);
            	if(h.compareLessThan()){
            		System.out.println(h.getNum1()+" is less than "+h.getNum2());
            	}
            	else{
            		System.out.println(h.getNum1()+" is not less than "+h.getNum2());
            	}
                break; 
            case 0:
                System.exit(0);
                break;
            default:
                
                break;
        }
		}while(ch !=0);

	}

}
