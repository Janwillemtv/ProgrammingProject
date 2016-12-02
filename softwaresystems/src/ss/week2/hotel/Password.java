package ss.week2.hotel;

import ss.week3.pw.Checker;
import ss.week3.pw.BasicChecker;

import java.util.Objects;

//import java.math.*;
public class Password {

	private Checker checker;
	private String factoryPassword;
	private String passWord;
	public static final String INITIAL = "raspberry";

	public Password(Checker c) {
		checker = c;
		factoryPassword = checker.generatePassword();
        passWord = factoryPassword;
	}

	public Password() {
        this(new BasicChecker());
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
		if (oldPass.equals(passWord) && checker.acceptable(newPass)) {
			restart();
			passWord = newPass;
			return true;
			
		} else {
			System.out.println("Please try again");
			return false;
		}
	}

    public void restart() {

    }

    public Checker getChecker() {
		return checker;
	}

	public String getFactoryPassword() {
		return factoryPassword;
	}
	public void testThis() {
		//empty, to make the assertFalse(constructor) work
	}
}
