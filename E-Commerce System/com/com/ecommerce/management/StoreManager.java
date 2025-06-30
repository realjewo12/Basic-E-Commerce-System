package com.ecommerce.management;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.Customer;
import com.ecommerce.Product;

/**
 * The {@code StoreManager} class simulates a store manager system
 * that tracks all customers and products. It provides methods to
 * display all registered customers and available products.
 * 
 * This class is useful for central control of store operations.
 * 
 * @author Dibena Jeanne
 * @version 1.0
 */
public class StoreManager {

    private List<Customer> customerList;
    private List<Product> productList;

    public StoreManager() {
        this.customerList = new ArrayList<>();
        this.productList = new ArrayList<>();
    }

    /**
     * Adds a product to the product catalog.
     * 
     * @param product the product to be added
     */
    public void addProduct(Product product) {
        productList.add(product);
    }

    /**
     * Adds a customer to the registered customer list.
     * 
     * @param customer the customer to be added
     */
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    /**
     * Displays a list of all available products in the store.
     */
    public void viewAllProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available in the store.");
            return;
        }
        System.out.println("=== Product Catalog ===");
        for (Product product : productList) {
            System.out.println("- " + product);
        }
    }

    /**
     * Displays a list of all registered customers.
     */
    public void viewAllCustomers() {
        if (customerList.isEmpty()) {
            System.out.println("No customers have registered yet.");
            return;
        }
        System.out.println("=== Registered Customers ===");
        for (Customer customer : customerList) {
            System.out.println("- " + customer.getFullName() + " (ID: " + customer.getCustomerID() + ")");
        }
    }

    // Optional: Getters
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Product> getProductList() {
        return productList;
    }
}

