package ss.week3.hotel;

import java.text.DecimalFormat;
/**
 * Created by Tom on 5-12-2016.
 */
public class Format {

     public void printLine(String text, double amount) {
        DecimalFormat formatter = new DecimalFormat("#.00");
         String format = "%-30s%s%n";
        // System.out.println(format, text, amount);
        System.out.println(String.format(format, text, String.format("%.2f", amount)));
        //return text;
    }
    public static void main(String[] args) {
    this.printLine("Test this", 1);
   // this.printLine("Hahahahahahaha", 45.12);
    }

}

