package ss.week4.math;

/**
 * Created by janwillem on 12/5/16.
 */
public class Exponent implements Function, Integrandable {

    private int exponent;

    public Exponent(int exponent) {
        this.exponent = exponent;
    }


    public double apply(double d) {
        return Math.pow(d, exponent);
    }


    public Function derivative() {
        return new LinearProduct(new Constant(exponent), new Exponent(exponent - 1));
    }


    public Function integrand() {
        double newExp = exponent + 1;
        return new LinearProduct(new Constant(1/(newExp)), new Exponent((int) newExp));
    }


    public String toString() {
        return "(x ^ " + exponent + ")";
    }
}
