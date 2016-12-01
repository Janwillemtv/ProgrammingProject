package ss.week2;

public class Rectangle {
    private int length;
    private int width;
    /*@ private invariant length >= 0; @*/ //class invariant
    /*@	private invariant width >= 0; @*/ //class invariant

    
    /**
     * Create a new Rectangle with the specified length and width.
     */
    /*@ requires theLength >= 0;
  		requires theWidth >= 0;
  		ensures length() >= 0;
  		ensures width() >= 0;
  	*/
    public Rectangle(int theLength, int theWidth) {
    	assert theLength >= 0;
    	assert theWidth >= 0;
    	length = theLength;
    	width = theWidth;
    }
    
    /**
     * The length of this Rectangle.
     */
    //@ ensures \result >= 0;
    /*@ pure */public int length() {
    	return length;
    }

    /**
     * The width of this Rectangle.
     */
    //@ ensures \result >= 0;
    /*@ pure */ public int width() {
    	return width;
    }

    /**
     * The area of this Rectangle.
     */
    /*@ ensures \result >= 0;
     	ensures \result == length()*width();
    */
    public int area() {
    	return length * width;
    }

    /**
     * The perimeter of this Rectangle.
     */
	/*@	ensures \result >= 0;
    	ensures \result == (2*width()) + (2 * length());
    */
	public int perimeter() {
		assert length >= 0;
    	assert width >= 0;
		return (2 * width) + (2 * length);
    }
}
