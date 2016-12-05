package ss.week3.hotel;

/**
 * Created by Tom on 5-12-2016.
 */
public class PricedSafe extends Safe implements Bill.Item {
    private double price;
    public PricedSafe (double price) {
        super();
        this.price = price;
    }

    @Override
    public double getAmount() {
        return price;
    }

    @Override
    public String toString() {
        return "Safe" + this.price;
    }
}
