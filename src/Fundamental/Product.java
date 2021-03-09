package Fundamental;

/*
 * Product class
 */
public class Product {
	private int pid;
	private String name;
	private Double price;
	private int stock;

	/*
	 * Constructor to initialize product details
	 * 
	 * @param pid Product ID, name Product Name, price Product Price, stock
	 * Items available
	 */
	public Product(int pid, String name, Double price, int stock) {
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	/*
	 * Method to get name of product
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/*
	 * Method to set name of the product
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Method to get price of the product
	 * 
	 * @return price
	 */
	public Double getPrice() {
		return price;
	}

	/*
	 * Method to price of the product
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/*
	 * Method to get stock of the product
	 */
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	/*
	 * Method to get Product ID of the product
	 * 
	 * @return pid
	 */
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
}
