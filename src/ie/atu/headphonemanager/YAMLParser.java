package ie.atu.headphonemanager;

import java.io.*;
import java.util.*;

public class YAMLParser {

    // Parse a simple YAML file (structure: key: value)
    public static Map<String, String> parseYAML(String filePath) {
        Map<String, String> data = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty() && line.contains(":")) {
                    String[] parts = line.split(":", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    data.put(key, value);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading YAML file: " + e.getMessage());
        }
        return data;
    }

    // Save data to a simple YAML file
    public static void saveToYAML(String filePath, Map<String, String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : data.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Data saved to YAML file.");
        } catch (IOException e) {
            System.out.println("Error saving YAML file: " + e.getMessage());
        }
    }
}
