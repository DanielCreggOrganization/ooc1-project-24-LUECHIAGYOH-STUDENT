package ie.atu.headphonemanager;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HeadphonesManager {
    private ArrayList<Headphones> headphones;
    private static int nextId = 1; // Unique ID counter

    public HeadphonesManager() {
        this.headphones = new ArrayList<>();
    }

    public void addHeadphones(Headphones h) {
        h.setId(nextId++); // Assign a unique ID
        headphones.add(h);
        System.out.println("Headphones added successfully: " + h);
    }

    public void deleteHeadphones(String model) {
        headphones.removeIf(h -> h.getModel().equalsIgnoreCase(model));
        System.out.println("If found, the headphone was deleted.");
    }

    public int getTotalHeadphones() {
        return headphones.size();
    }

    public Headphones searchHeadphones(String model) {
        for (Headphones h : headphones) {
            if (h.getModel().equalsIgnoreCase(model)) {
                return h;
            }
        }
        return null;
    }

    public void listHeadphones() {
        if (headphones.isEmpty()) {
            System.out.println("No headphones in the list.");
        } else {
            for (Headphones h : headphones) {
                System.out.println(h);
            }
        }
    }

    public void sortHeadphonesByPrice() {
        headphones.sort(Comparator.comparingDouble(Headphones::getPrice));
        System.out.println("Headphones sorted by price.");
        listHeadphones();
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("headphones.dat"))) {
            oos.writeObject(headphones);
            System.out.println("Headphones saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving headphones to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("headphones.dat"))) {
            headphones = (ArrayList<Headphones>) ois.readObject();
            System.out.println("Headphones loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading headphones from file: " + e.getMessage());
        }
    }
}
