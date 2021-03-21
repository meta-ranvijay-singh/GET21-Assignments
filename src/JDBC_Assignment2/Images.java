package JDBC_Assignment2;

import java.util.ArrayList;
import java.util.List;

//Class for image url
public class Images {
	private int product_id;
	private List<String> images;

	// Constructor
	public Images(int productId, List<String> imageUrl) {
		product_id = productId;
		images = new ArrayList<String>();
		for (String image : imageUrl) {
			images.add(image);
		}
	}

	/*
	 * Method to get product id
	 */
	public int getProductId() {
		return product_id;
	}

	/*
	 * Method to get list of image url
	 */
	public List<String> getImageUrl() {
		List<String> imageUrl = new ArrayList<String>();

		for (String image : images) {
			imageUrl.add(image);
		}

		return imageUrl;
	}

}
