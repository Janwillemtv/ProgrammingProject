package ss.week2;

import ss.week2.hotel.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class safeTest {
    private Safe safe;

    @Before
    public void setup() {
        safe = new Safe();
    }

    @Test
    public void testInnitialConditions() {
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
        assertTrue(safe.getPassword().testWord("raspberry"));
    }

    @Test
    public void testActivation() {
        assertFalse(safe.activate("wrong"));
        assertFalse(safe.isActive());
        assertTrue(safe.activate("raspberry"));
        assertTrue(safe.isActive());
        safe.deactivate();
        assertFalse(safe.isActive());
    }

    @Test
    public void testOpening() {
        assertFalse(safe.open("wrong"));
        assertFalse(safe.isOpen());
        assertFalse(safe.open("raspberry"));
        assertFalse(safe.isOpen());
        assertTrue(safe.activate("raspberry"));
        assertTrue(safe.open("raspberry"));
        assertTrue(safe.isOpen());
        safe.close();
        assertFalse(safe.isOpen());
        safe.open("raspberry");
        assertTrue(safe.isOpen());
        safe.deactivate();
        assertFalse(safe.isOpen());
    }

    @Test
    public void testPassword() {
        assertTrue(safe.getPassword().testWord("raspberry"));
    }

}
