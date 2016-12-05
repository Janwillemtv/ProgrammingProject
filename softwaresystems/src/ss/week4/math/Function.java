package ss.week4.math;

/**
 * Created by janwillem on 12/5/16.
 */
public interface Function {
    double apply(double d);

    Function derivative();

    String toString();
}
