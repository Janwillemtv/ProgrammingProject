package ss.week3.hotel;

/**
 * Created by Tom on 5-12-2016.
 */
public class PricedRoom extends Room implements Bill.Item{
   // PricedSafe thisSafe;
    private int roomNumber;
    private double price;
    public PricedRoom(int number, double roomPrice, double safePrice){
    super(number/*, new PricedSafe(safePrice)*/);
       // thisSafe = new PricedSafe(safePrice);

        this.roomNumber = number;
        this.price = roomPrice;
    }
    @Override
    public double getAmount() {
        return price;
    }
    @Override
    public String toString() {
        return String.format("Room %d - %s per night", getNumber(), getAmount());
    }
}
