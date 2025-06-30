package com.ecommerce;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ecommerce.orders.Orders;

/**
* The {@code Customer} class represents a customer in the e-commerce system.
* It manages customer profile information and the shopping cart.
* Customers can add or remove products from their cart, and place orders.
* 
* @author Dibena Jeanne
* @version 1.0
*/
public class Customer {
	
	private String customerID;
	private String fullName;
	private String email;
	private String phoneNumber;
	private String address;
	private Date registrationDate;
	private boolean isActive;
	private List<Product> shoppingCart;
	private List<Orders> orderHistory = new ArrayList<>();
	
	/**
     * Constructs a new Customer with the basic identity information.
     * Initializes an empty shopping cart and sets registration date to the current time.
     *
     * @param customerID  unique ID for the customer
     * @param fullName    customer's full name
     * @param email       customer's email
     */
	public Customer(String customerID, String fullName, String email) {
		this.customerID = customerID;
        this.fullName = fullName;
        this.email = email;
        this.shoppingCart = new ArrayList<>();
        this.registrationDate = new Date();
        this.isActive = true;
	}
	
	// Getters and Setters
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Product> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(List<Product> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Orders> getOrderHistory() {
	    return orderHistory;
	}

	/**
     * Adds a product to the customer's shopping cart.
     *
     * @param product the product to be added
     */
	public void addToCart(Product product) {
		shoppingCart.add(product);
	}
	
	/**
     * Removes a product from the customer's shopping cart.
     *
     * @param product the product to be removed
     */

	public void removeFromCart(Product product) {
		shoppingCart.remove(product);
	}
	
	/**
     * Calculates the total cost of all items currently in the shopping cart.
	 * @return 
     *
     * @return total price as a double
     */
	public double calculateTotalCost() {
		return shoppingCart.stream().mapToDouble(Product::getFinalPrice).sum();
	}
	
	/**
     * Simulates placing an order.
     * (This method should ideally create an Orders object in a real system.)
     */
	public void placeOrder() {
	    if (shoppingCart.isEmpty()) {
	        System.out.println("Your cart is empty. Please add items before placing an order.");
	    } else {
	        Orders newOrder = new Orders(this, new ArrayList<>(shoppingCart));
	        orderHistory.add(newOrder);
	        System.out.println("Order placed successfully!\n" + newOrder.getOrderSummary());
	        shoppingCart.clear();
	    }
	}

	public boolean isActive() {
		return isActive;
	}

	/**
	 * Displays the contents of the customer's shopping cart.
	 * <p>
	 * If the cart is empty, a message indicating so is printed. 
	 * Otherwise, each product in the cart is listed along with its name 
	 * and final price after any applied discount.
	 * </p>
	 * 
	 * This method is useful for reviewing current selections before placing an order.
	 */
	public void viewCart() {
	    if (shoppingCart.isEmpty()) {
	        System.out.println("Shopping cart is empty.");
	    } else {
	        System.out.println("Shopping Cart:");
	        for (Product p : shoppingCart) {
	            System.out.println("- " + p.getName() + ": $" + p.getFinalPrice());
	        }
	    }
	}

	@Override
	public String toString() {
	    return fullName + " (ID: " + customerID + ", Email: " + email + ")";
	}

}
