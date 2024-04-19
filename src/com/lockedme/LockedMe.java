package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class LockedMe {

    // Define the directory path
    private static String directoryPath = System.getProperty("user.dir") + "/testFiles/";

    // Method to add a new file
    public static void addFile(Scanner scanner) {
        System.out.print("Enter the file name to create: ");
        String fileName = scanner.next();

        System.out.print("Enter the content to write to the file: ");
        String fileContent = scanner.next(); 

        // Create a new file object
        File newFile = new File(directoryPath + fileName + ".txt");

        try {
            // Check if file creation is successful
            if (newFile.createNewFile()) {
                FileWriter fileWriter = new FileWriter(newFile);
                fileWriter.write(fileContent);
                fileWriter.close();
                System.out.println("File created and content added successfully!");
            } else {
                System.out.println("File already exists. Content not added.");
            }
        } catch (IOException e) {
            // Handle IO exception
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        } 
    }

    // Method to delete a file
    public static void deleteFile(Scanner scanner) {
        System.out.print("Enter file name which you want to delete: ");
        String fileName = scanner.next();

        // Create a file object to delete
        File fileToDelete = new File(directoryPath + fileName + ".txt");

        if (!fileToDelete.exists()) {
            System.out.println("**File either does not exist or the name is incorrect!");
            return;
        }

        // Delete the file
        boolean isDeleted = fileToDelete.delete();

        if (isDeleted) {
            System.out.println("File deleted successfully!");
        } else {
            System.out.println("Error found in deleting the file!");
        }
    }

    // Method to search for a file
    public static void searchFile(Scanner scanner) {
        // Declare variables
        File lockedMeDB = new File(directoryPath);
        File[] files = lockedMeDB.listFiles();
        boolean isFileFound = false;
        String fileName;

        System.out.print("Enter the file name to be searched: ");
        fileName = scanner.next();
        
        if (files == null) {
            System.out.println("There is no file present in the directory !");
            return;
        }

        // Search for the file
        for (File file : files) {
            if (file.getName().contains(fileName)) {
                isFileFound = true;
                break;
            }
        }

        if (isFileFound) {
            System.out.println("Filename '" + fileName + "' was found!");
        } else {
            System.out.println("Filename '" + fileName + "' not found!");
        }

    }

    // Method to display all files
    public static void displayAllFiles() {
        // Declare and initialize variables
        File lockedMeDB = new File(directoryPath);
        File[] files = lockedMeDB.listFiles();

        if (files != null) {
            SortedSet<String> fileNames = new TreeSet<>();

            // Add filenames to the sorted set
            for (File file : files) {
                fileNames.add(file.getName());
            }

            // Print the filenames in ascending order
            System.out.println("Here are your files in ascending order");
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }

    // Method to display the welcome message
    public static void displayWelcomeMessage() {
        System.out.println("***************************************************");
        System.out.println("*        Virtual Key For Your Repositories        *");
        System.out.println("*                  Locker.com                     *");
        System.out.println("*                                                 *");
        System.out.println("*               Nicholas Rabalao                  *");
        System.out.println("*           Java Full Stack Developer             *");
        System.out.println("***************************************************");
    }

    // Method to display the main menu
    public static void displayMainMenu() {
        System.out.println("\n*********** Main Menu ***********");
        System.out.println("1. Display files in ascending order.");
        System.out.println("2. Add/Delete/Search Menu");
        System.out.println("3. Exit Application");
        System.out.print("Enter your menu choice: ");
    }

    // Method to display the sub-menu
    public static void displaySubMenu() {
        System.out.println("\n*********** Operations Menu ***********");
        System.out.println("1. Add a new file");
        System.out.println("2. Delete a file");
        System.out.println("3. Search for a file");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your menu choice: ");
    }

    // Method to exit the application
    public static void exit() {
        System.out.println("\nExiting Application...");
        System.out.println("Thank you for using the Application!");
        System.exit(0);
    }
}