package com.ecommerce;

import java.io.Serializable;
import java.util.Date;

/**
* The {@code Product} class represents a product in an e-commerce system.
* It contains essential attributes such as product ID, name, price, description,
* category, stock availability, and discount. 
* <p>
* This class also includes business logic methods for calculating discounted
* prices and checking inventory status.
* </p>
* 
* @author Dibena Jeanne
* @version 1.0
*/
public class Product implements Serializable {

    private String productID;
    private String name;
    private double price;
    private String description;
    private String category;
    private int stockQuantity;
    private boolean available;
    private double rating;
    private Date dateAdded;
    private double discount; 

    /**
     * Constructs a basic product with a product ID, name, and base price.
     * Initializes availability to true and sets the dateAdded to the current date.
     *
     * @param productID the unique identifier of the product
     * @param name      the name of the product
     * @param price     the base price of the product
     */
    public Product(String productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.available = true;
        this.dateAdded = new Date(); 
    }

    // Getters and Setters
    public String getProductID() { 
    	return productID; 
    }
    
    public void setProductID(String productID) { 
    	this.productID = productID;
    }

    public String getName() { 
    	return name; 
    }
    
    public void setName(String name) { 
    	this.name = name; 
    }

    public double getPrice() { 
    	return price; 
    }
    
    public void setPrice(double price) { 
    	this.price = price; 
    }

    public String getDescription() { 
    	return description; 
    }
    
    public void setDescription(String description) { 
    	this.description = description; 
    }

    public String getCategory() { 
    	return category; 
    }
    
    public void setCategory(String category) { 
    	this.category = category; 
    }

    public int getStockQuantity() { 
    	return stockQuantity; 
    }
    
    public void setStockQuantity(int stockQuantity) { 
    	this.stockQuantity = stockQuantity; 
    }

    public boolean isAvailable() { 
    	return available; 
    }

	public void setAvailable(boolean available) { 
		this.available = available; 
	}

	public double getRating() { 
		return rating; 
	}

	public void setRating(double rating) { 
		this.rating = rating; 
	}

	public Date getDateAdded() { 
		return dateAdded; 
	}

	public void setDateAdded(Date dateAdded) { 
		this.dateAdded = dateAdded; 
	}

	public double getDiscount() { 
		return discount; 
	}

	public void setDiscount(double discount) { 
		this.discount = discount; 
	}

	/**
     * Converts the product to a String array for CSV export.
     * 
     * @return a String[] representing the product's fields.
     */
    public String[] toCSVRow() {
        return new String[] {
            productID,
            name,
            String.valueOf(price),
            description != null ? description : "",
            category != null ? category : "",
            String.valueOf(stockQuantity),
            String.valueOf(available),
            String.valueOf(rating),
            dateAdded != null ? dateAdded.toString() : ""
        };
    }

    /**
     * Gets CSV column headers.
     * 
     * @return an array of column header strings
     */
    public static String[] getCSVHeaders() {
        return new String[] {
            "ProductID", "Name", "Price", "Description", "Category",
            "StockQuantity", "Available", "Rating", "DateAdded"
        };
    }
    
    /**
     * Calculates and returns the final price of the product after applying the discount.
     *
     * @return the price after discount
     */
    public double getFinalPrice() {
        return price - (price * discount/100);
    }

    /**
     * Checks if the product is currently in stock.
     *
     * @return {@code true} if stock quantity is greater than 0, {@code false} otherwise
     */
    public boolean isInStock() {
        return stockQuantity > 0;
    }

    /**
     * Applies a discount to the product if the percentage is between 0 and 40.
     *
     * @param percentage the discount rate (e.g., 20 for 20% off)
     */
    public void applyDiscount(double percentage) {
        if (percentage >= 0 && percentage <= 40) {
            this.discount = percentage;
        }
    }

    /**
     * Returns a string representation of the product for display purposes.
     *
     * @return a string containing the product name, ID, and final price
     */
    @Override
    public String toString() {
        return name + " (" + productID + ") - $" + getFinalPrice();
    }
}
