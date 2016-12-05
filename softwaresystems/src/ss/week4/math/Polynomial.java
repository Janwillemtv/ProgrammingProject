package ss.week4.math;

/**
 * Created by janwillem on 12/5/16.
 */
import java.util.ArrayList;
import java.util.List;

public class Polynomial implements Function, Integrandable {

    private List<LinearProduct> functions;

    public Polynomial(double[] as) {
        functions = new ArrayList<LinearProduct>();

        for (int i = 0; i < as.length; i++) {
            functions.add(new LinearProduct(new Constant(as[i]), new Exponent(as.length - i)));
        }
    }


    public double apply(double d) {
        double result = 0;

        for (LinearProduct p :
                functions) {
            result += p.apply(d);
        }

        return result;
    }


    public Function derivative() {

        Sum sum = null;

        for(int i = 1; i < functions.size(); i++) {
            if(sum == null) {
                LinearProduct p1 = (LinearProduct) functions.get(i-1).derivative();
                LinearProduct p2 = (LinearProduct) functions.get(i).derivative();

                sum = new Sum(p1, p2);
            } else {
                LinearProduct p = (LinearProduct) functions.get(i).derivative();
                sum = new Sum(sum, p);
            }
        }

        return sum;
    }


    public Function integrand() {
        Sum sum = null;

        for(int i = 1; i < functions.size(); i++) {
            if(sum == null) {
                LinearProduct p1 = (LinearProduct) functions.get(i - 1).integrand();
                LinearProduct p2 = (LinearProduct) functions.get(i).integrand();

                sum = new Sum(p1, p2);
            } else {
                LinearProduct p = (LinearProduct) functions.get(i).integrand();
                sum = new Sum(sum, p);
            }
        }

        return sum;
    }


    public String toString() {
        String message = "";

        for(int i = 0; i < functions.size(); i++) {
            Function f = functions.get(i);

            message += f.toString() + " ";
        }

        return message;
    }
}
