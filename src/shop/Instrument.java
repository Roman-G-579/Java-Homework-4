package shop;

public abstract class Instrument {

    protected static int serialNum = 0;
    private String company;
    private int price;
    protected int serial;

    public Instrument(String company, int price) {
        this.company = company;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getCompany() {
        return company;
    }

    public int getSerial(){
        return serial;
    }
}