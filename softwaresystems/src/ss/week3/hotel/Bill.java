package ss.week3.hotel;

import java.io.PrintStream;
/**
 * Created by Tom on 5-12-2016.
 */
public class Bill {
    private Item item;
    static Format myFormat;

    private PrintStream out;
    public Bill() {
        myFormat.printLine("Hi there", 76);
    }
    public interface Item {

        //method returns a double
        public double getAmount();

    }
    public static void main(String args[]) {
    }
}
