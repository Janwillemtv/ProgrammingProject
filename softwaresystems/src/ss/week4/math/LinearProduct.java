package ss.week4.math;

/**
 * Created by janwillem on 12/5/16.
 */
public class LinearProduct extends Product implements Integrandable{

    public LinearProduct(Constant b, Function a) {
        super(a, b);
    }

    public Function derivative() {
        return new LinearProduct((Constant) b, a.derivative());
    }

    public Function integrand() {
        if(a instanceof Integrandable) {
            return new LinearProduct((Constant) b, ((Integrandable) a).integrand());
        }

        return null;
    }
}