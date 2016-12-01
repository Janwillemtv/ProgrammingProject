package ss.week2;

import java.util.*;
//byte state;


public class threeWayLamp {
//	int state;
	public enum State {
		OFF, LOW, MEDIUM, HIGH;
	}
	State state;
	String switchState;
	String prevState;
//	String[] states = {"No light", "A bit of Light", "normal Light", "MY EYES THEY HURT!"};
	static Scanner userInput = new Scanner(System.in);
//@ensures state.equals("OFF");
public threeWayLamp(State state) {
	this.state = state;
	//this.state = state.values();
	switchState = "";
	prevState = switchState;
	//System.out.println(state);
	this.giveLight();
}

//method of ensuring that the state changes, convert it to an integer +1 
//and run a modulo operand on it if the same it has moved to the next variable
//@ensures (\old(currentState()) + 1) % 4 == currentState();
public void switchState() {
	System.out.println("Enter any key");
	
	if(userInput.hasNextLine()) {
		switchState = (String) userInput.nextLine();
		if (switchState != prevState) {
			switch (state) {
			case OFF:
				state = State.LOW;
				break;
			case LOW:
				state = State.MEDIUM;
				break;
			case MEDIUM:
				state = State.HIGH;
				break;
			case HIGH:
				state = State.OFF;
				break;
			}		
		}
				
		prevState = switchState;
		System.out.println(switchState);
		}
	if (currentState() == 1) System.out.println("Fuck this");
	}

/*@pure */ public int currentState() {
	//return ordinal().state;
	
	switch (state) {
	case OFF:
		return 0;
		//break;
	case LOW:
		return 1;
		//break;
	case MEDIUM:
		return 2;
		//break;
	case HIGH:
		return 3;
		//break;	
	default:
		return 0;
		//break;
	}
}


public void giveLight() {
	System.out.println("Amount of light =" + " "+ state);
}
public static void main(String[] args) {
	threeWayLamp lamp = new threeWayLamp(State.OFF);
	while (true) {
		lamp.switchState();
		lamp.giveLight();
		}
	}
}

