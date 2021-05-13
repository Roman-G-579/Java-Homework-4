package shop;

public abstract class Instrument {

    protected static int serialNum = -1;
    private String company;
    private int price;

    public Instrument(String company, int price) {
        this.company = company;
        this.price = price;
        serialNum++;
    }

    public int getPrice() {
        return price;
    }

    public String getCompany() {
        return company;
    }

    public abstract int getSerial();
}