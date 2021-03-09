package Fundamental;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private final List<Product> products = new ArrayList<Product>();

    /*
     * Constructor to initialize store items
     */
    public Products () {
        this.initStoreItems();
    }
    
    /*
     * Method to get list of products
     */
    public List<Product> getProducts() {
        return products;
    }
    
    /*
     * Method to initialize store items
     */
    public void initStoreItems() {
        String [] productNames = {"Parle G", "Face Wash", "Denium Jeans"};
        Double [] productPrice = {10.00d, 60.00d, 3000.00d};
        Integer [] stock = {10, 6, 10};
        
        for (int i=0; i < productNames.length; i++) {
            this.products.add(new Product(i+1, productNames[i], productPrice[i], stock[i]));
        }
    }
}