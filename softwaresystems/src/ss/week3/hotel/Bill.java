package ss.week3.hotel;

import java.io.PrintStream;
/**
 * Created by Tom on 5-12-2016.
 */
public class Bill {
    private Item item;
    //static Format myFormat;

    private double sum;

    private PrintStream out;
    public Bill(PrintStream output) {
        //myFormat.printLine("Hi there", 76);
        sum = 0;
    }
    public interface Item {

        //method returns a double
        public double getAmount();

    }
    public void newItem(Item item) {
        if (item != null) {
            if(out != null) {
                out.println(Format.printLine(item.toString(), item.getAmount()));
            }
            sum += item.getAmount();
        }
    }
    public void total() {
        if (out != null) {
            out.println(Format.printLine("Total Price", sum));
        }
    }

    public static void main(String args[]) {
        //myFormat.printLine("test number 2", 45.00);
    }
}
