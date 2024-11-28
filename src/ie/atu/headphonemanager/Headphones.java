package ie.atu.headphonemanager;

public class Headphones {

    // Instance Variables
    private String brand; // Unique10
    private String model;
    private float price;
    private boolean isWireless;

    public Headphones(String brand, String model, float price, boolean isWireless) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.isWireless = isWireless;
    }

    // getter and Setter Methods
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

    public void setWireless(boolean wireless) {
        isWireless = wireless;
    }

    @Override
    public String toString() {
        return "Headphones [Brand=" + brand + ", Model=" + model + ", Price=" + price + ", Wireless=" + isWireless + "]";
    }

    public void add(Headphones headphones) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }



   


}