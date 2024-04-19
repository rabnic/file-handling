package com.lockedme;

import java.util.Scanner;

import com.lockedme.LockedMe;

public class App {

    public static void main(String[] args) {
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Declare variables for menu choices
        int mainChoice;
        int subChoice;

        // Display welcome message
        LockedMe.displayWelcomeMessage();

        do {
            // Display main menu
            LockedMe.displayMainMenu();

            // Get user input for main menu choice
            if (scanner.hasNextInt()) {
                mainChoice = getIntInput(scanner);
            } else {
                // Handle invalid input
                System.out.println("  Please enter a valid menu choice!");
                scanner.next();
                continue;
            }

            // Perform actions based on main menu choice
            switch (mainChoice) {
                case 1:
                    // Display all files
                    LockedMe.displayAllFiles();
                    break;
                case 2:
                    do {
                        // Display submenu
                        LockedMe.displaySubMenu();
                        // Get user input for submenu choice
                        subChoice = getIntInput(scanner);
                        // Perform actions based on submenu choice
                        switch (subChoice) {
                            case 1:
                                // Add a new file
                                LockedMe.addFile(scanner);
                                break;
                            case 2:
                                // Delete a file
                                LockedMe.deleteFile(scanner);
                                break;
                            case 3:
                                // Search for a file
                                LockedMe.searchFile(scanner);
                                break;
                            case 4:
                                // Exit submenu
                                break;
                            default:
                                // Handle invalid input
                                System.out.println("  Please enter a valid menu choice!");
                        }
                    } while (subChoice != 4);
                    break;
                case 3:
                    // Exit application
                    scanner.close();
                    LockedMe.exit();
                    break;
                default:
                    // Handle invalid input
                    System.out.println("  Please enter a valid menu choice!");
            }

        } while (true);
    }

    // Method to get integer input from user
    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer!");
            scanner.next();
        }
        return scanner.nextInt();
    }
}