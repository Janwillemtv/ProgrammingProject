package ss.week4.math;

/**
 * Created by janwillem on 12/5/16.
 */
public class Product implements Function {

    protected Function a, b;

    public Product(Function a, Function b) {
        this.a = a;
        this.b = b;
    }


    public double apply(double d) {
        return a.apply(d) * b.apply(d);
    }


    public Function derivative() {
        return new Sum(new Product(a.derivative(), b), new Product(a, b.derivative()));
    }


    public String toString() {
        return "(" + b.toString() + " * " + a.toString() + ")";
    }
}