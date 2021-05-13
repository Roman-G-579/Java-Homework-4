package shop;

public class Guitar extends Instrument {

    private String company;
    private int price;
    private Type type;
    private int serial;

    public Guitar(String company, int price, Type type) {
        super(company, price);
        this.type = type;
        this.company = company;
        this.price = price;
        serial = serialNum;
    }

    public Type getType() {
        return type;
    }

    public int getSerial() {
        return serial;
    }

    public String toString() {
        return "Guitar(" + type + ") " + company + "(" + serial + ")" + ", price = " + price;
    }
}
