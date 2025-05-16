package com.kjcourse.util;

import java.util.Scanner;

/**
 * Utility class for reading validated input from the user.
 */
public class InputValidator {

    private static final Scanner scan = new Scanner(System.in);

    // Method to avoid storing empty or whitespace-only strings
    public static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scan.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty. Please enter a valid value.");
        }
    }

    // Method to read a valid integer
    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scan.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static float readFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Float.parseFloat(scan.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid decimal number (e.g., 78.5).");
            }
        }
    }
}
