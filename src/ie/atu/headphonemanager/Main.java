package ie.atu.headphonemanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        HeadphonesManager manager = new HeadphonesManager();

        int userSelection;

        while (true) {
            System.out.println("\n###################################");
            System.out.println("# Headphone Manager v1.1          #");
            System.out.println("###################################");
            System.out.println("(1) Add a Headphone.");
            System.out.println("(2) Delete a Headphone.");
            System.out.println("(3) Show total number of Headphones.");
            System.out.println("(4) Search for a Headphone by Model.");
            System.out.println("(5) List all Headphones.");
            System.out.println("(6) Sort Headphones by Price.");
            System.out.println("(7) Save Headphones to File.");
            System.out.println("(8) Load Headphones from File.");
            System.out.println("(9) Quit.");
            System.out.print("Select an option (1-9): ");

            try {
                userSelection = Integer.parseInt(userInput.nextLine()); // Safe integer input

                switch (userSelection) {
                    case 1 -> {
                        userInput.nextLine(); // Clear the buffer after nextInt
                        System.out.print("Enter Brand: ");
                        String brand = userInput.nextLine();
                        System.out.print("Enter Model: ");
                        String model = userInput.nextLine();  // Use nextLine() to consume the leftover newline

                        // Accept price as a string to handle currency symbols
                        System.out.print("Enter Price (e.g., 100): ");
                        String priceInput = userInput.nextLine();  // Read input as String
                        float price = 0;
                        try {
                            // Remove currency symbols (like €) and parse the number
                            price = Float.parseFloat(priceInput.replaceAll("[^0-9.]", ""));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid price entered. Please try again.");
                            break;
                        }

                        System.out.print("Is it Wireless (true/false): ");
                        boolean isWireless = userInput.nextBoolean();
                        userInput.nextLine(); // Clear the buffer after nextBoolean

                        if (isWireless) {
                            System.out.print("Enter Battery Life (hours): ");
                            int batteryLife = userInput.nextInt();
                            userInput.nextLine(); // Clear the buffer after nextInt
                            WirelessHeadphones newHeadphone = new WirelessHeadphones(brand, model, price, true, batteryLife);
                            manager.addHeadphones(newHeadphone);
                        } else {
                            Headphones newHeadphone = new Headphones(brand, model, price, false);
                            manager.addHeadphones(newHeadphone);
                        }
                        System.out.println("Headphone added successfully.");
                    }

                    case 2 -> {
                        System.out.print("Enter Model to Delete: ");
                        String model = userInput.nextLine();
                        manager.deleteHeadphones(model);
                    }

                    case 3 -> System.out.println("Total Headphones: " + manager.getTotalHeadphones());

                    case 4 -> {
                        System.out.print("Enter Model to Search: ");
                        String model = userInput.nextLine();
                        Headphones h = manager.searchHeadphones(model);
                        System.out.println(h != null ? h : "Headphones not found.");
                    }

                    case 5 -> manager.listHeadphones();

                    case 6 -> manager.sortHeadphonesByPrice();  // Sort by price

                    case 7 -> manager.saveToFile();

                    case 8 -> manager.loadFromFile();

                    case 9 -> {
                        System.out.println("Exiting Headphone Manager. Bye!");
                        userInput.close();
                        return;
                    }

                    default -> System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
