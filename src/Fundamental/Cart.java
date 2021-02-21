package Fundamental;

import java.util.ArrayList;
import java.util.List;

public class Cart<T> {
    List<T> cartItems = new ArrayList<T>();
    
    public List<T> getCartItems(){
        return cartItems;
    }

    public void addToCart(T product) {
        cartItems.add(product);
        System.out.println("Added successfully!!");
    }

    public void removeProductByPID(T prod) {
            if(prod!=null){
                cartItems.remove(prod); 
                System.out.println("Removed successfully!!");
            }
            else{
                System.out.println("Not Found!!!");
            }
    } 
    public void updateCart(T prod, int pos){
    	cartItems.set(pos, prod);
        System.out.println("Updated successfully!!");
    }
}