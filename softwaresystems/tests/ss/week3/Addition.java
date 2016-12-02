package ss.week3.test;

import ss.week3.OperatorWithIdentity;

/**
 * Created by Tom on 2-12-2016.
 */
public class Addition implements OperatorWithIdentity {
    public int operate(int left, int right) {
        return left + right;
    }
    public int identity() {
        return 0;
    }
}
