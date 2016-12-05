package ss.week1;

public class DollarsAndCentsCounter {
	
	private int dollars;
	private int cents;
	
	public DollarsAndCentsCounter() {
				
		
	}
	
	public void add(int d, int c) {
		dollars += d;
		cents += c;
		if (cents >= 100) {
			dollars += (int) (cents / 100);
			cents = cents % 100;		
		}
	}
	
	public void subtract(int d, int c) {
		dollars -= d;
		cents -= c;
		if (cents < 0) {
			dollars -= (int) (cents / 100);
			cents = 100 - (cents % 100);
		}
		if (dollars < 0) {
			dollars = 0;	
		}
	}
	
	
	public void reset() {
		dollars = 0;
		cents = 0;		
	}
	
	public int dollars() {
		return dollars;
	}
	
	public int cents() {
		return cents;
	}
}
