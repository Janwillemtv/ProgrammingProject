package ss.week5.tictactoe;

import java.util.*;

/**
 * Created by Tom on 19-12-2016.
 */
public class NaiveStrategy implements Strategy {
    public String strategyName;

    NaiveStrategy(String n) {
    strategyName = n;
    }
     public String getName() {
        return strategyName;
    }
    @Override
    public int determineMove(Board b, Mark m) {
        int choice;
        Board boardCopy = b.deepCopy();
        do {
            int randNumber = (int)(Math.random()* boardCopy.size());
        //make a choice
            choice = boardCopy.isEmptyField(randNumber) ? randNumber : -1;
        } while (choice == -1);

        return choice;
    }
}
