package ss.week2.test;
import ss.week2.hotel.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ss.week2.hotel.Guest;
import ss.week2.hotel.Room;

public class RoomTest {
    private Guest guest;
    private Room room;

    @Before
    public void setUp() {
        guest = new Guest("Jip");
        room = new Room(101);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
    
    @Test
    public void testSafe() {
    	room.getSafe().getPassword().setWord("raspberry", "testing");
    	room.getSafe().activate("testing");
    	room.getSafe().open("testing");
    	assertTrue(room.getSafe().isOpen());
    }
}
