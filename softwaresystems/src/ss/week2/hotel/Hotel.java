package ss.week2.hotel;
import ss.week2.hotel.*;
/**
 * Hotel with rooms and Guests.
 * @author Janwillem te Voortwis
 * @version $Revision: 0.1 $
 */
public class Hotel {
	private Password password;
	public Room room1;
	public Room room2;
	private String name;


	public Hotel(String n) {
		name = n;
		password = new Password();
		
		room1 = new Room(1);
		room2 = new Room(2);
	}
	
	public Room checkIn(String pass, String n) {
		//check if the password is correct
		if (getPassword().testWord(pass)) {
			//check if the guest is already checked in
			if (getRoom(n) != null) {
				return null;
			}
			// get a free room
			Room room = getFreeRoom();
			// check if the hotel is full --> null rooms
			if (room == null) {
				return null;
			}
			// check the guest in the room
			Guest guest = new Guest(n);
			guest.checkin(room);
			return room;
			
		} else {
			return null;
		}	
	
	}
	
	
	public void checkOut(String n) {
		// get room of the guest
		Room room = getRoom(n);
		// check if the guest is checked in
		if (room != null) {
			//checkout the guest and deactivate the safe
			room.getGuest().checkout();
			room.getSafe().deactivate();
		}
	}
	
	public Room getFreeRoom() {
		// check rooms for guest
		if (room1.getGuest() == null) {
			// return room if empty
			return room1;
		} else if (room2.getGuest() == null) {
			return room2;
		} else {
			//when full return null
			return null;
		}
	}
	
	public Room getRoom(String n) {
		//check room for guest
		if (room1.getGuest() == null) {
			return null;
		} else if (room1.getGuest().getName().equals(n)) {
			//if found return room
			return room1;
		} else if (room2.getGuest() == null) {
			return null;
		} else if (room2.getGuest().getName().equals(n)) {
			return room2;
		} else {
			//not found return null
			return null;
		}
	}
		
	public Password getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Hotel: " + name + " Room1: " + room1.getGuest().getName() + " Safe: Active=" + room1.getSafe().isActive() + " Open=" + room1.getSafe().isOpen() +
				" Room1: " + room1.getGuest().getName() + " Safe: Active=" + room1.getSafe().isActive() + " Open=" + room1.getSafe().isOpen();
	}
}
	

