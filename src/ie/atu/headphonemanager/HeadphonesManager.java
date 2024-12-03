package ie.atu.headphonemanager;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HeadphonesManager {
    private ArrayList<Headphones> headphones;

    public HeadphonesManager() {
        this.headphones = new ArrayList<>();
    }

    // Add headphones to the list
    public void addHeadphones(Headphones h) {
        headphones.add(h); // ID is assigned automatically when the object is created
        System.out.println("Headphones added successfully: " + h);
    }

    // Delete headphones by model
    public void deleteHeadphones(String model) {
        headphones.removeIf(h -> h.getModel().equalsIgnoreCase(model));
        System.out.println("If found, the headphone was deleted.");
    }

    // Get total number of headphones
    public int getTotalHeadphones() {
        return headphones.size();
    }

    // Search for headphones by model
    public Headphones searchHeadphones(String model) {
        for (Headphones h : headphones) {
            if (h.getModel().equalsIgnoreCase(model)) {
                return h;
            }
        }
        return null;
    }

    // List all headphones
    public void listHeadphones() {
        if (headphones.isEmpty()) {
            System.out.println("No headphones in the list.");
        } else {
            for (Headphones h : headphones) {
                System.out.println(h);
            }
        }
    }

    // Sort headphones by price
    public void sortHeadphonesByPrice() {
        headphones.sort(Comparator.comparingDouble(Headphones::getPrice));
        System.out.println("Headphones sorted by price.");
        listHeadphones();
    }

    // Save headphones to file
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("headphones.dat"))) {
            oos.writeObject(headphones);
            System.out.println("Headphones saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving headphones to file: " + e.getMessage());
        }
    }

    // Load headphones from file
    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        File file = new File("headphones.dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                headphones = (ArrayList<Headphones>) ois.readObject();
                System.out.println("Headphones loaded from file.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading headphones from file: " + e.getMessage());
            }
        } else {
            System.out.println("No saved headphones file found.");
        }
    }
}
