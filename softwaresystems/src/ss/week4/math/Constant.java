package ss.week4.math;

/**
 * Created by janwillem on 12/5/16.
 */
public class Constant implements Function, Integrandable {

    private double value;

    public Constant(double d) {
        this.value = d;
    }


    public double apply(double d) {
        return value;
    }


    public Function derivative() {
        return new Constant(0);
    }


    public String toString() {
        return "(" + Double.toString(value) + ")";
    }


    public Function integrand() {
        return new Product(this, new Exponent(1));
    }
}