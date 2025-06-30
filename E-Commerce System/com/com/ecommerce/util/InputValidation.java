package com.ecommerce.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidation {

    private static Scanner scanner = new Scanner(System.in);
    private static final Pattern EMAIL_PATTERN = 
            Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a valid integer.");
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a valid number.");
            }
        }
    }

    public static LocalDate readDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("❌ Invalid date format. Please use YYYY-MM-DD.");
            }
        }
    }

    public static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("❌ Input cannot be empty.");
        }
    }
    
    // getValidNumber for range-bound input
    public static int getValidNumber(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("❌ Please enter a number between " + min + " and " + max + ".");
        }
        // int choice = InputValidation.getValidNumber("Choose an option: ", 1, 5);

    }
    
    // Useful to confirm deletion or exit
    public static boolean confirmYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            System.out.println("❌ Please enter 'y' or 'n'.");
        }
    }

    // To read choice selected from a list
    public static String readChoice(String prompt, String[] options) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            for (String option : options) {
                if (option.toLowerCase().equals(input)) {
                    return option;
                }
            }
            System.out.println("❌ Invalid choice. Available options: " + String.join(", ", options));
        }
    }

    // To check phone number basic format
    public static String readPhoneNumber(String prompt) {
        while (true) {
            String phone = readNonEmptyString(prompt);
            if (phone.matches("\\d{6,15}")) {  // Adjust length as needed
                return phone;
            }
            System.out.println("❌ Invalid phone number. Please enter digits only (6–15 digits).");
        }
    }

    // Get positive numbers
    public static int readPositiveInt(String prompt) {
        while (true) {
            int value = readInt(prompt);
            if (value > 0) return value;
            System.out.println("❌ Please enter a positive number.");
        }
    }

    public static double readPositiveDouble(String prompt) {
        while (true) {
            double value = readDouble(prompt);
            if (value > 0) return value;
            System.out.println("❌ Please enter a positive amount.");
        }
    }

    /**
     * Prompts the user and reads a valid email address.
     * Keeps prompting until a valid email format is entered.
     *
     * @param scanner the scanner object used to read input
     * @param prompt  the prompt message to display
     * @return a valid email address
     */
    public static String readValidEmail(String prompt) {
        String email;
        while (true) {
            System.out.print(prompt);
            email = scanner.nextLine().trim();
            if (EMAIL_PATTERN.matcher(email).matches()) {
                return email;
            }
            System.out.println("Invalid email format. Please try again.");
        }
    }

}
