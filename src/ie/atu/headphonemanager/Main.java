package ie.atu.headphonemanager;

import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        HeadphonesManager manager = new HeadphonesManager();

        // Path for the YAML file to store/load data
        String yamlFilePath = "headphones.yaml";

        int userSelection;

        while (true) {
            System.out.println("\n###################################");
            System.out.println("# Headphone Manager v1.2          #");
            System.out.println("###################################");
            System.out.println("(1) Add a Headphone.");
            System.out.println("(2) Delete a Headphone.");
            System.out.println("(3) Show total number of Headphones.");
            System.out.println("(4) Search for a Headphone by Model.");
            System.out.println("(5) List all Headphones.");
            System.out.println("(6) Sort Headphones by Price.");
            System.out.println("(7) Save Headphones to File.");
            System.out.println("(8) Load Headphones from File.");
            System.out.println("(9) Set Maximum Array Size.");
            System.out.println("(10) List Headphones by ID.");
            System.out.println("(11) Save Data to YAML File.");
            System.out.println("(12) Load Data from YAML File.");
            System.out.println("(13) Quit.");
            System.out.print("Select an option (1-13): ");

            try {
                userSelection = Integer.parseInt(userInput.nextLine()); // Safe integer input

                switch (userSelection) {
                    case 1 -> {
                        System.out.print("Enter Brand: ");
                        String brand = userInput.nextLine();
                        System.out.print("Enter Model: ");
                        String model = userInput.nextLine();

                        System.out.print("Enter Price (e.g., 100): ");
                        String priceInput = userInput.nextLine(); 
                        float price = 0;
                        try {
                            price = Float.parseFloat(priceInput.replaceAll("[^0-9.]", ""));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid price entered. Please try again.");
                            break;
                        }

                        System.out.print("Is it Wireless (true/false): ");
                        boolean isWireless = Boolean.parseBoolean(userInput.nextLine());

                        if (isWireless) {
                            System.out.print("Enter Battery Life (hours): ");
                            int batteryLife = Integer.parseInt(userInput.nextLine());
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

                    case 3 -> System.out.println("Total Headphones: " + manager.getTotalHeadphones());

                    case 4 -> {
                        System.out.print("Enter Model to Search: ");
                        String model = userInput.nextLine();
                        Headphones h = manager.searchHeadphones(model);
                        System.out.println(h != null ? h : "Headphones not found.");
                    }

                    case 5 -> manager.listHeadphones();

                    case 6 -> manager.sortHeadphonesByPrice();

                    case 7 -> manager.saveToFile();

                    case 8 -> manager.loadFromFile();

                    case 9 -> {
                        System.out.print("Enter maximum size for headphone list: ");
                        int size = Integer.parseInt(userInput.nextLine());
                        manager.setMaxSize(size);
                    }

                    case 10 -> manager.listHeadphonesById();

                    case 11 -> {
                        // Save data to YAML file
                        Map<String, String> dataToSave = manager.getHeadphonesData();  // You will need to implement this method to return data as key-value pairs
                        YAMLParser.saveToYAML(yamlFilePath, dataToSave);
                    }

                    case 12 -> {
                        // Load data from YAML file
                        Map<String, String> loadedData = YAMLParser.parseYAML(yamlFilePath);
                        System.out.println("Loaded Data from YAML: " + loadedData);
                        // You may need to update the manager to load the data properly if necessary
                    }

                    case 13 -> {
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
