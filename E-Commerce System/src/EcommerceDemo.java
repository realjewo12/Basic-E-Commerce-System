import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.orders.Orders;
import com.ecommerce.util.IdGenerator;
import com.ecommerce.util.InputValidation;
import com.ecommerce.management.ProductManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EcommerceDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> productCatalog = new ArrayList<>();

        productCatalog.add(new Product("P001", "Laptop", 999.99));
        productCatalog.add(new Product("P002", "Smartphone", 699.49));
        productCatalog.add(new Product("P003", "Wireless Mouse", 29.95));
        productCatalog.add(new Product("P004", "Mechanical Keyboard", 89.99));
        productCatalog.add(new Product("P005", "Monitor 24-inch", 159.99));
        productCatalog.add(new Product("P006", "External Hard Drive 1TB", 74.50));
        productCatalog.add(new Product("P007", "USB-C Charger", 19.99));
        productCatalog.add(new Product("P008", "Bluetooth Headphones", 129.00));
        productCatalog.add(new Product("P009", "Webcam HD 1080p", 49.99));
        productCatalog.add(new Product("P010", "Laptop Stand", 32.99));

        ProductManager.exportProductsToCSV(productCatalog);
        
        // Load Products from File
        productCatalog = ProductManager.loadProductsFromCSV("products.csv");

        // Create a customer
        String fullName = InputValidation.readNonEmptyString("Enter your full name: ");

        String email = InputValidation.readValidEmail("Enter your email address: ");

        String customerID = IdGenerator.generateCustomerId();
        
        Customer customer = new Customer(customerID, fullName, email);

        // Browse and add products to cart
        boolean shopping = true;
        while (shopping) {
            System.out.println("\n--- Product Catalog ---");
            for (int i = 0; i < productCatalog.size(); i++) {
                Product p = productCatalog.get(i);
                System.out.println((i + 1) + ". " + p.getName() + " - $" + p.getPrice());
            }

            int choice = InputValidation.getValidNumber("Select a product number to add to cart (0 to finish): ", 0, productCatalog.size());

            if (choice == 0) {
                shopping = false;
            } else {
                Product selectedProduct = productCatalog.get(choice - 1);
                customer.addToCart(selectedProduct);
                System.out.println(selectedProduct.getName() + " added to your cart.");
            }
        }

        // Place Order
        customer.viewCart();
        
        boolean confirm = InputValidation.confirmYesNo("\nWould you like to place the order? (yes/no): ");

        if (confirm) {
            Orders order = new Orders(customer, customer.getShoppingCart());
            customer.placeOrder();

            System.out.println("\n--- Order Summary ---");
            System.out.println(order.getOrderSummary());
        } else {
            System.out.println("Order was not placed. You can come back later.");
        }

        scanner.close();
    }
}
