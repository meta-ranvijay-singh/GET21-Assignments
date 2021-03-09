package Fundamental;

import java.util.ArrayList;
import java.util.List;

/*
 * Generic type cart
 */
public class Cart<T> {
	List<T> cartItems = new ArrayList<T>();

	/*
	 * Method to get list of cart items
	 * 
	 * @return cartItems List
	 */
	public List<T> getCartItems() {
		return cartItems;
	}

	/*
	 * Method to product int the cart
	 * 
	 * @param product object
	 */
	public void addToCart(T product) {
		cartItems.add(product);
		System.out.println("Added successfully!!");
	}

	/*
	 * Method to remove item from the cart
	 * 
	 * @return prod object of product class
	 */
	public void removeProductByPID(T prod) {
		if (prod != null) {
			cartItems.remove(prod);
			System.out.println("Removed successfully!!");
		} else {
			System.out.println("Not Found!!!");
		}
	}

	/*
	 * Method to update quantity of cart items
	 * 
	 * @return prod product object to be update, pos position of the product in
	 * cartItems list
	 */
	public void updateCart(T prod, int pos) {
		cartItems.set(pos, prod);
		System.out.println("Updated successfully!!");
	}
}