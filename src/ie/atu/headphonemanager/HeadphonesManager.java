package ie.atu.headphonemanager;

import java.util.ArrayList;

public class HeadphonesManager {
    private static ArrayList<Headphones> headphones;

    public HeadphonesManager() {
        headphones = new ArrayList<>();
    }

    public static void addHeadphones(Headphones headphone) { // Renamed parameter to "headphone"
        headphones.add(headphone); // Now correctly adds to the ArrayList
        System.out.println("Headphones added successfully.");
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

    public static void listHeadphones() {
        if (headphones.isEmpty()) {
            System.out.println("No headphones in the list.");
        } else {
            for (Headphones h : headphones) {
                System.out.println(h);
            }
        }
    }
}
