package ss.week1.hotel;
/**
 * Guest with name and room number.
 * @author Janwillem te Voortwis
 * @version $Revision: 0.1 $
 */
public class Guest extends java.lang.Object {
	// ------------------ Instance variables ----------------
	private java.lang.String name;
	private Room room;
	
	// ------------------ Constructor ------------------------
	/**
     * Creates a <code>Guest</code> with a given name, without a room.
     * @param n name of the new <code>Guest</code>
     */
	public Guest(java.lang.String n) { 
		name = n;
		
	}
	
	// ------------------ Queries --------------------------

    /**
     * Check this <code>Guest</code> in a room if the room is empty and this <code>Guest</code> 
     * has no room yet.
     * @param r number of the room of the <code>Guest</code>
     * @return <code>true</code>;
     *         <code>false</code> if this <code>Guest</code> 
     *         is already checked in or the room is taken
     */
	public boolean checkin(Room r)	{
		if (room == null && r.getGuest() == null) {
			room = r;
			r.setGuest(this);
			return true;
		} else {
			return false;	
		}
	}
	 /**
     * Check this <code>Guest</code> out a room.
     * @return <code>true</code>;
     *         <code>false</code> if this <code>Guest</code> 
     *         is not checked in
     */
	public boolean checkout() {
		if (room != null) {
			room.setGuest(null);
			room = null;
			return true;
		} else {
			return false;
		}
		
	}
	/**
     * Returns the name of this <code>Guest</code>.
     */
	public java.lang.String getName() {	
		return name;
	}
	
	/**
     * Returns the current room of this <code>Guest</code>.
     * @return the room of this <code>Guest</code>;
     *         <code>null</code> if this <code>Guest</code> 
     *         is not checked in
     */
	public Room getRoom() {
		return room;
	
	}
	/**
     * Returns String representation of <code>Guest</code>.
     */
	public java.lang.String toString() {
		return "Guest: name = " + name + " Room = " + room.getNumber();
		
	}
}
