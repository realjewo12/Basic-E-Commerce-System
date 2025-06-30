package com.ecommerce.management;

import com.ecommerce.Product;
import com.ecommerce.util.CSVExporter;
import com.ecommerce.util.FileHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ProductManager} class is responsible for managing the list of products.
 * It provides functionality to load and save products using file utilities,
 * and export them as CSV for external use.
 *
 * This class supports persistent product management for the e-commerce system.
 *
 * @author Dibena Jeanne
 * @version 1.0
 */
public class ProductManager {

    private static final String PRODUCT_DATA_FILE = "products.dat";
    private static final String PRODUCT_CSV_FILE = "products.csv";

    /**
     * Loads the product list from the serialized data file.
     *
     * @return a list of products loaded from file
     */
    public static List<Product> loadProducts(String fileName) {
        return FileHelper.loadFromFile(fileName);
    }

    /**
     * Saves the current product list to a serialized file.
     *
     * @param products the list of products to be saved
     */
    public static void saveProducts(List<Product> products) {
        FileHelper.saveToFile(new ArrayList<>(products), PRODUCT_DATA_FILE);
    }

    /**
     * Exports the product list to a CSV file for viewing or backup.
     *
     * @param products the list of products to export
     */
    public static void exportProductsToCSV(List<Product> products) {
        List<String[]> rows = new ArrayList<>();
        String[] headers = {"Product ID", "Name", "Price"};
        for (Product p : products) {
            String[] row = {
                    p.getProductID(),
                    p.getName(),
                    String.valueOf(p.getPrice())
            };
            rows.add(row);
        }
        CSVExporter.exportToCSV(rows, PRODUCT_CSV_FILE, headers);
    }
    
    public static List<Product> loadProductsFromCSV(String fileName) {
        List<Product> productList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip headers
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());

                    productList.add(new Product(id, name, price));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return productList;
    }

}
