package ie.atu.headphonemanager;

import java.io.Serializable;

public class Headphones implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id; // Unique identifier
    private String brand;
    private String model;
    private float price;
    private boolean isWireless;

    public Headphones(String brand, String model, float price, boolean isWireless) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.isWireless = isWireless;
    }

    // Getter and setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    @Override
    public String toString() {
        return "Headphones{" +
                "ID=" + id +
                ", Brand='" + brand + '\'' +
                ", Model='" + model + '\'' +
                ", Price=" + price +
                ", Wireless=" + isWireless +
                '}';
    }
}
