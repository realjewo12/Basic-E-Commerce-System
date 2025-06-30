package com.ecommerce.orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.util.IdGenerator;

/**
 * The {@code Orders} class represents an order placed by a customer.
 * It contains details such as the customer, list of products, total price,
 * and current status of the order.
 * 
 * This class provides methods to summarize the order, update status,
 * and manage order-related information.
 * 
 * @author Dibena Jeanne
 * @version 1.0
 */
public class Orders {

	private String orderID;
	private Customer customer;
	private List<Product> products;
	private double orderTotal;
	private String status;
	private Date orderDate;
	private PaymentDetails paymentDetails;
	private ShippingAddress shippingAddress;
	
	/**
     * Constructs a new order for a given customer and list of products.
     *
     * @param customer the customer who placed the order
     * @param products the list of products included in the order
     */
	public Orders(Customer customer, List<Product> products) {
	this.orderID = IdGenerator.generateStringId();
	this.customer = customer;
	this.products = new ArrayList<>(products);
	this.orderTotal = calculateTotal(products);
	this.status = "Pending"; // Default status
	this.orderDate = new Date();
	}
	
	// Getters
    public String getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public String getStatus() {
        return status;
    }
    
	public void setPaymentDetails(PaymentDetails paymentDetails) {
	    this.paymentDetails = paymentDetails;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
	    this.shippingAddress = shippingAddress;
	}

	/**
	 * Calculates the total price for all products in the order.
	 *
	 * @param products list of products
	 * @return the total price
	 */
	private double calculateTotal(List<Product> products) {
	    return products.stream().mapToDouble(Product::getFinalPrice).sum();
	}

	/**
	 * Returns a summary of the order including customer name, products, and total.
	 *
	 * @return formatted order summary
	 */
	public String getOrderSummary() {
		StringBuilder summary = new StringBuilder();
	    summary.append("Order ID: ").append(orderID).append("\n");
	    summary.append("Customer: ").append(customer.getFullName()).append("\n");
	    summary.append("Order Date: ").append(orderDate).append("\n");
	    summary.append("Status: ").append(status).append("\n");
	    summary.append("Products:\n");
	    for (Product product : products) {
	        summary.append("- ").append(product.getName()).append(": $").append(product.getFinalPrice()).append("\n");
	    }
	    summary.append("Total: $").append(orderTotal).append("\n");
	    if (paymentDetails != null) {
	        summary.append("Payment: ").append(paymentDetails.toString()).append("\n");
	    }
	    if (shippingAddress != null) {
	        summary.append("Shipping To: ").append(shippingAddress.toString()).append("\n");
	    }
	    return summary.toString();
	}

	/**
	 * Updates the status of the order (e.g., "Shipped", "Delivered").
	 *
	 * @param newStatus the new status to be set
	 */
	public void updateStatus(String newStatus) {
	    this.status = newStatus;
	}
    
}
