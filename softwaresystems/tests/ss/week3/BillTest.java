package ss.week3;

import org.junit.Test;
import ss.week3.hotel.Bill;
import org.junit.Before;
import org.junit.Test;
import ss.week3.hotel.Item;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tom on 9-12-2016.
 */
public class BillTest {
    Bill bill;
    @Before
            public void setup() {
        this.bill = new Bill(null);
    }
    @Test
    public void testBill() throws Exception {
        assertEquals("Total Price", 0, (int) bill.total());
        bill.newItem(new Item("Room 1", 7.50));
        assertEquals("Total Price", 7, (int) bill.total());
        bill.newItem(new Item("Room 2", 10.50));

        assertEquals("Total Price", 18, (int) bill.total());

        }

       // assertEquals(7.50, bill.Item.getAmount);


        //assertEquals("GetAmount should return the price of the room.", PRICE, item.getAmount(), 0);
    }

