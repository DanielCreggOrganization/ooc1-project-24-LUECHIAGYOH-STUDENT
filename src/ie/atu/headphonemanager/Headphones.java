package ie.atu.headphonemanager;

public class Headphones {

    // Instance Variables
    private int serialNumber; // Unique10
    private String brand;
    private float price;
    private boolean isSold;

    // getter and Setter Methods
    public int getSerialNumber(){
        return this.serialNumber;
    }

    public String getbrand(){
        return this.brand;
    }

    public float getprice(){
        return this.price;
    }

    public boolean getisSold(){
        return this.isSold;
    }

    public void getbrand(String brand){
        this.brand = brand;
    }

    public void getserialNumber(int serialNumber){
        this.serialNumber = serialNumber;
    }

    public void getprice(float price){
        this.price = price;
    }

    public void getisSold(boolean isSold){
        this.isSold = isSold;
    }

    

    



}
