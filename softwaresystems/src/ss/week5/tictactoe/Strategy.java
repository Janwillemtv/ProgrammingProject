package ss.week5.tictactoe;

/**
 * Created by Tom on 19-12-2016.
 */
public interface Strategy {

    public String getName();

    public int determineMove(Board b, Mark m);
}
