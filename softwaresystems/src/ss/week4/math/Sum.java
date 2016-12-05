package ss.week4.math;

/**
 * Created by janwillem on 12/5/16.
 */
public class Sum implements Function, Integrandable{

    private Function a, b;

    public Sum(Function a, Function b) {
        this.a = a;
        this.b = b;
    }

    public double apply(double d) {
        return a.apply(d) + b.apply(d);
    }

    public Function derivative() {
        return new Sum(a.derivative(), b.derivative());
    }

    public String toString() {
        return a.toString() + " + " + b.toString();
    }

    public Function integrand() {
        if(a instanceof Integrandable && b instanceof Integrandable) {
            return new Sum(((Integrandable) a).integrand(), ((Integrandable) b).integrand());
        }

        return null;
    }
}