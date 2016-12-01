package ss.week2.test;

import org.junit.*;

import ss.week2.Rectangle;

import static org.junit.Assert.assertEquals;


/**
 * Testprogram for Rectangle.
 * Lab Exercise SoftwareSystems
 * @author Janwillem te Voortwis
 * @version $ 1.0 $
 */
public class RectangleTest {
	private Rectangle square;

	/**
     * Sets initial variables to a well-defined initial value.
     *
     */
	@Before
	public void setup() {
		square = new Rectangle(30, 30);
	}

	 /**
     * Test if the initial condition complies to the specification.
     */
	@Test
	public void testInitialcondition() {
		assertEquals(30, square.length());
		assertEquals(30, square.width());
		assertEquals(900, square.area());
		assertEquals(120, square.perimeter());
	}

}

