package com.ecommerce.util;

import java.io.*;
import java.util.ArrayList;

public class FileHelper {

    public static <T> void saveToFile(ArrayList<T> list, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(list);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> loadFromFile(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ArrayList<T>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // return empty list if file doesn't exist
        }
    }
}
