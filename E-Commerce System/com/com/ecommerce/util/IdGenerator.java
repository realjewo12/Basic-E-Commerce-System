
package com.ecommerce.util;

import java.util.UUID;

public class IdGenerator {
    private static int currentId = 2025070001;

    // Generates a unique positive integer ID
    public static int generateIntId() {
        return currentId++;
    }
    
    public static String generateStringId() {
        return UUID.randomUUID().toString(); // return a random crypted id like f786b5fa-812c-4ec5-9ff4-978efd4fc1b2
    }
    
    private static int customerCounter = 1;

    /**
     * Generates a new unique customer ID in the format C001, C002, etc.
     *
     * @return the generated customer ID
     */
    public static String generateCustomerId() {
        return String.format("C%03d", customerCounter++);
    }

}

