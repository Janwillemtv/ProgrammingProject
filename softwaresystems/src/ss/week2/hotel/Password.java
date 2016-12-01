package ss.week2.hotel;

import java.util.Objects;

//import java.math.*;
public class Password {
	
	private String passWord;
	public static final String INITIAL = "raspberry";
	public Password() {
		//super();
		passWord = INITIAL;
		
	}
	public boolean acceptable(String in) {
		if (in.length() > 6 && !in.contains(" ")) {
			return true;
		} else {
			return false;
		}
	}
	/*@ pure */public boolean testWord(String in) {
		if (Objects.equals(in, passWord)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean setWord(String oldPass, String newPass) {
		if (oldPass.equals(passWord) && acceptable(newPass)) {
			
			passWord = newPass;
			return true;
			
		} else {
			System.out.println("Please try again");
			return false;
		}
	}
	public void testThis() {
		//empty, to make the assertFalse(constructor) work
	}
}
