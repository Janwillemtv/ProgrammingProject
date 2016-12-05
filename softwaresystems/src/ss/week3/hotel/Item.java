package ss.week3.hotel;

/**
 * Created by Tom on 5-12-2016.
 */

public class Item implements Bill.Item {

    private String text;
    private double amount;

    public Item(String text, double amount) {
    this.text = text;
    this.amount = amount;
}
    //@Override
    public double getAmount() {
            return amount;
    }
    @Override
    public String toString() {
        return text;
    }
}
