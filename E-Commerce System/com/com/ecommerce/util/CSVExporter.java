package com.ecommerce.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {
    public static void exportToCSV(List<String[]> rows, String fileName, String[] headers) {
        try (FileWriter writer = new FileWriter(fileName)) {
            if (headers != null) {
                writer.write(String.join(",", headers));
                writer.write("\n");
            }
            for (String[] row : rows) {
                writer.write(String.join(",", row));
                writer.write("\n");
            }
            System.out.println("Data exported to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to CSV: " + e.getMessage());
        }
    }
}
