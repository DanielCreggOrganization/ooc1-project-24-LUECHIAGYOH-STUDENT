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
      System.out.println("\n###################################");
      System.out.println("# Headphone Manager v1.0 #");
      System.out.println("###################################");
      System.out.println("(1) Add a Headphone.");
      System.out.println("(2) Delete a Headphone.");
      System.out.println("(3) Show total number of Headphones.");
      System.out.println("(4) Search for a Headphone by Model.");
      System.out.println("(5) List all Headphones.");
      System.out.println("(5) Quit.");
      System.out.println("Select an option from 1 to 6 and press Enter>");


      // Store user Menu option selection
      userSelection = userInput.nextInt();
      userInput.nextLine(); // Consume newline

      switch (userSelection) {
        case 1 -> {
          System.out.print("Enter Brand: ");
          String brand = userInput.nextLine();
          System.out.print("Enter Model: ");
          String model = userInput.nextLine();
          System.out.print("Enter Price: ");
          float price = userInput.nextFloat();
          System.out.print("Is it Wireless (true/false): ");
          boolean isWireless = userInput.nextBoolean();
          if (isWireless) {
            System.out.print("Enter Battery Life (hours):" );
            int batteryLife = userInput.nextInt();
            manager.addHeadphones(new WirelessHeadphones(brand, model, price, true, batteryLife));
          } else {
            manager.addHeadphones(new Headphones(brand, model, price, false));

          }
        }
        case 2 -> {
          System.out.print("Enter Model to Delete: ");
          String model = userInput.nextLine();
          manager.deleteHeadphones(model);
        
        }
        case 3 -> System.out.println("Total Headphones:" + manager.getTotalHeadphones());
        case 4 -> {
          System.out.print("Enter Model to Search: ");
          String model = userInput.nextLine();
          Headphones h = manager.searchHeadphones(model);
          System.out.println(h != null ? h : "Headphones not found.");
        }
        case 5 -> manager.listHeadphones();
        case 6 -> {
          System.out.println("Exiting Headphone Manager. Bye!");
          userInput.close();
          return;
        }
        default -> System.out.println("Invalid selection. Please try again.");
            
          }

          }

        }
      }
      
