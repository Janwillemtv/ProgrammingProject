package ss.week4;

/**
 * Created by janwillem on 12/5/16.
 */

import org.junit.Before;
import org.junit.Test;
import ss.week4.math.Polynomial;
import ss.week4.math.Sum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PolynomialTest {

    private Polynomial p;
    private static final double DELTA = 1e-15;

    @Before
    public void setUp() {
        p = new Polynomial(new double[] {7, 3, 1});
    }

    @Test
    public void testApply() {
        assertEquals(11, p.apply(1), DELTA);
        assertEquals(70, p.apply(2), DELTA);
        assertEquals(0, p.apply(0), DELTA);
    }

    @Test
    public void testDerivative() {
        assertTrue(p.derivative() instanceof Sum);
        assertEquals(28, p.derivative().apply(1), DELTA);
    }

    @Test
    public void testIntegrand() {
        assertTrue(p.integrand() instanceof Sum);
        assertEquals(3.25, p.integrand().apply(1), DELTA);
    }
}