package shop;

public abstract class Instrument {

    protected static int serialNum;
    protected int serial;
    private String company;
    private int price;

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

    public int getSerial() {
        return serial;
    }
}