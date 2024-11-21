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

    public void getserialNumber(int serialNumber){
        this.serialNumber = serialNumber;
    }

    public float getprice(){
        return this.price;
    }

    public void getprice(int price){
        this.price = price;
    }

    public boolean getisSold(){
        return this.isSold;
    }



}
