package shop;

public class Piano extends Instrument {

    private String company;
    private int price;
    private int octaves;

    public Piano(String company, int price, int octaves) {
        super(company, price);
        this.octaves = octaves;
        this.price = price;
        this.company = company;
    }

    public int getOctaves() {
        return octaves;
    }

    public String toString() {
        return "Piano(" + octaves + " octaves) " + company +
                "(" + serialNum + ")" + ", price = " + price;
    }
}
