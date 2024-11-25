package ie.atu.headphonemanager;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {

    // Instantiate Scanner class so we can start reading user input
    Scanner userInput = new Scanner(System.in);
    int userSelection = 0; 


      // Create infinite while loop to display Menu after every command
    while (true) {
      // Display Menu to console
      System.out.println("");
      System.out.println("###################################");
      System.out.println("# Headphone Manager v0.1 #");
      System.out.println("###################################");
      System.out.println("(1) Add a Headphone.");
      System.out.println("(2) Delete a Headphone.");
      System.out.println("(3) Show total number of Headphone.");
      System.out.println("(4) Search for a Headphone by ID.");
      System.out.println("(5) Quit.");
      System.out.println("Select an option from 1 to 5 and press Enter>");


      // Store user Menu option selection
      userSelection = userInput.nextInt();

      if (userSelection == 5) { // Quit

         System.out.println("Headphone Application Closing - Goodbye!");
         // Close the User Input Scanner
         userInput.close();
         break; // Break out of display Menu infinite loop 
      } // and if
    } // end while
   } // and main method
} // end Main class
