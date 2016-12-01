package ss.week2.hotel;

public class Safe {
	private boolean isActive;
	private boolean isOpen;
	private Password password;
	//@ invariant isOpen() == true ==> isActive() == true;
	//@ invariant isActive() == false ==> isOpen() == false;
	
//	public static void main(String[] args) {
//		Safe safe = new Safe("raspberry ");
//	}
//	
	

	//@ ensures isActive() == isOpen() == false;
	public Safe() {
		password = new Password();
		isActive = isOpen = false;
	}
	
	//@ requires getPassword().testWord(pass) == true;
	//@	ensures isActive() == true;
	public boolean activate(String pass) {
		if (password.testWord(pass)) {
			isActive = true;
			return true;
		} else {
			return false;
		}
	}
	
	//@ ensures isActive() == false;
	//@	ensures isOpen() == false;
	public void deactivate() {
		isActive = false;
		isOpen = false;
	}
	
	//@ requires getPassword().testWord(pass) == true;
	//@	ensures isOpen() == true;
	public boolean open(String pass) {
		if (password.testWord(pass) && isActive) {
			isOpen = true;
			return true;
		}
		return false;
	}
	
	//@ ensures isOpen() == false;
	public void close() {
		isOpen = false;
		
	}
	
	//@ensures \result == isActive();
	/*@ pure */public boolean isActive() {
		return isActive;
	}
	
	//@ensures \result == isOpen();
	/*@ pure */public boolean isOpen() {
		return isOpen;
	}
	
	//@ensures \result == getPassword();
	/*@ pure */public Password getPassword() {
		return password;
	}
}
