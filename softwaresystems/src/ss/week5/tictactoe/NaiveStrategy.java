package ss.week5.tictactoe;

import java.util.*;

/**
 * Created by Tom on 19-12-2016.
 */
public class NaiveStrategy implements Strategy {
    public static final String strategyName = "Naive";

    NaiveStrategy() {

    }
     public String getName() {
        return strategyName;
    }
    @Override
    public int determineMove(Board b, Mark m) {
        int choice;
        Board boardCopy = b.deepCopy();
       // choice = (int)(Math.random()* boardCopy.size() +1);

      //  System.out.println(randNumber);
       // System.out.println(b.size());
        do {
            //int randNumber = 4;
            int randNumber = (int)(Math.random()* boardCopy.size());
        //make a choice
            choice = boardCopy.isEmptyField(randNumber) ? randNumber : -1;
        } while (choice == -1);

    //  choice = b.isEmptyField(8) ? 8 : -1;
        return choice;
    }
}
