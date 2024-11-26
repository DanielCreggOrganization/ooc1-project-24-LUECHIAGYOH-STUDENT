package ie.atu.headphonemanager;

public class WirelessHeadphones extends Headphones{
    private int batteryLife;

    public WirelessHeadphones(String brand, String model , float price, boolean isWireless, int batteryLife) {
        super(brand, model, price, isWireless);
        this.batteryLife = batteryLife;
    }
    
    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    @Override
    public String toString() {
        return super.toString() + ", Battery Life=" + batteryLife + " hours";
    }

}