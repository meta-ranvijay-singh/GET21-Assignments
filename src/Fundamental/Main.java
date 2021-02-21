package Fundamental;

import java.util.*;


class Shop{
    Cart<Product> cart = new Cart<Product>();
    private int ch = 0;
            List<Product> products ;
public Shop(){
    products = new Products().getProducts();
     menu();
}
Product getProductByProductID(int pid) {
    Product product = null;
    for (Product prod: products) {
        if (prod.getPid() == pid) {
            product = prod;
            break;
        }
    }
    return product;
}
Product getCartByProductID(int pid) {
    Product product = null;
    for (Product prod: cart.getCartItems()) {
        if (prod.getPid() == pid) {
            product = prod;
            break;
        }
    }
    return product;
}
public void startScreen () {
    System.out.println("1. Display Store Products");
    System.out.println("2. Display Cart");
    System.out.println("3. Add to Cart");
    System.out.println("4. Remove From Cart");
    System.out.println("5. Generate Bill");
    System.out.println("6. Update Cart");
    System.out.println("0. Exit");
}


public void menu () {
    do {
        startScreen();
        System.out.print("Enter : ");
        getUserInput();
        while(ch == -1){
            startScreen();
            System.out.print("Enter : ");
        getUserInput();
        }
        switch (ch) {
            case 1: 
                displayStoreProducts();
                break;
            case 2:
                showCart();
                break;
            case 3:
                addProductToCart();
            showCart();
                break;
            case 4:
                removeProductFromCart();
                break;
            case 5:
                Bill();
                break; 
            case 6:
            	System.out.print("Enter Product ID :");
                int pid = getUserInput();
                UpdateCart(pid);
                break; 
            case 0:
                System.exit(0);
                break;
            default:
                
                break;
        }
    } while (ch != 0);
}


private int getUserInput()  {
    Scanner in = new Scanner (System.in);
    
    String str= in.nextLine();
    if(str.equals("")){
        ch=-1;
    }
    else{
        ch = Integer.parseInt(str);
    }
    
    return ch;
}

private void displayStoreProducts() {
    List<Product> products = new Products().getProducts();
    System.out.printf("%5s %20s %10s %10s \n","P_ID","Name","Price","In Stock");
    for (Product prod: products) {
        System.out.printf("%5d %20s %10.2f %10d \n",prod.getPid(),prod.getName(),prod.getPrice(),prod.getStock());
    }
}

public void addProductToCart() {
    System.out.print("Enter Product ID :");
    int pid = getUserInput();
    Product prod=getCartByProductID(pid);
    if(prod == null){
    	prod=getProductByProductID(pid);
        if(prod == null){
            System.out.println("Product not Found!!!");
        }
        else{
            System.out.print("Enter quantity :");
            int q=getUserInput();
            if(prod.getStock()>=q){
                prod.setStock(q);
                cart.addToCart(prod);
            }
            else{
                System.out.println("Enter Quantity in limits");
            }
        }
    }
    else{
    	System.out.println("Already present in the cart. Want to change quantity?");
    	System.out.println("1.Yes");
    	System.out.println("2.No");
    	int ch=getUserInput();
    	if(ch == 1){
    		UpdateCart(pid);
    	}
    }
    
    
}
public void UpdateCart(int pid){

    List<Product> cartItems=cart.getCartItems();
    Product prod=getCartByProductID(pid);
    if(prod == null){
        System.out.println("Product not Found!!!");
    }
    else{
    	int pos=cartItems.indexOf(prod);
    	int stock=getProductByProductID(pid).getStock();
        System.out.print("Update quantity :");
        int q=getUserInput();
        if(stock>=q){
            prod.setStock(q);
            cart.updateCart(prod,pos);

        }
        else{
            System.out.println("Enter Quantity in limits");
        }
    }
}

private void showCart() {
    List<Product> cartItems=cart.getCartItems();
    int i=0;
    System.out.printf("%5s %5s %20s %10s %15s \n","S.No","P_ID","Name","Quantity","Total_Amount");
    for (Product prod: cartItems) {
        System.out.printf("%5d %5d %20s %10d %10.2f \n",++i,prod.getPid() ,prod.getName(),prod.getStock(),prod.getPrice()*prod.getStock());
    }
}
private void Bill() {
    List<Product> cartItems=cart.getCartItems();
    int i=0;
    Double sum=0.0;
    System.out.printf("%5s %5s %20s %15s %10s %15s \n","S.No","P_ID","Name","Price", "Quantity","Total_Amount");
    for (Product prod: cartItems) {
        System.out.printf("%5d %5d %20s %15.2f %10d %15.2f \n",++i,prod.getPid() ,prod.getName(),prod.getPrice() ,prod.getStock(),prod.getPrice()*prod.getStock());
        sum+=(prod.getPrice()*prod.getStock());
    }
    System.out.println("Total_Amount : "+sum);
    
}

private void removeProductFromCart() {
    System.out.print("Enter Product ID : ");
    int pid = getUserInput();
    Product prod=getCartByProductID(pid);
    cart.removeProductByPID(prod);

}
}

public class Main {

	public static void main(String[] args) {
		 new Shop();
	}

}
