package ie.atu.headphonemanager;

public class Headphones {

    // Instance Variables
    private int serialNumber; // Unique10
    private String brand;
    private float price;
    private boolean isSold;

    public Headphones(int serialNumber, String brand, float price, boolean isSold){
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.price = price;
        this.isSold = isSold;
    }




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
