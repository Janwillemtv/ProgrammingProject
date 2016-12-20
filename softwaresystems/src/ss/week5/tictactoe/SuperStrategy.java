package ss.week5.tictactoe;
import java.util.*;
/**
 * Created by Tom on 20-12-2016.
 */
public class SuperStrategy implements Strategy{
    String strategyName;
    private int difficulty;
    SuperStrategy (String n, int difficulty) {
        strategyName = n;
        this.difficulty = difficulty;
    }
    public String getName() {
        return strategyName;
    }
    public int determineMove(Board b, Mark m) {
        Board copy = b.deepCopy();
        //TODO Implement sick ALGORITHM

        return -1;
    }
}
