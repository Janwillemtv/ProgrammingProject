package ss.week5.tictactoe;

/**
 * Created by Tom on 19-12-2016.
 */


public class ComputerPlayer extends Player {

    public Strategy strategy;
    public ComputerPlayer(String n, Mark m) {
        super (n, m);
        switch (n) {
            case "-N":
                strategy = new NaiveStrategy();
                break;
            default:
                //do nothing yet
                break;
        }
    }
    public int determineMove(Board board) {
       // Board thisBoard = board.deepCopy();
       // int choice = strategy.determineMove(board, getMark());
        System.out.println("Strategy =" + strategy.determineMove(board, getMark()));
        return strategy.determineMove(board, getMark());
    }
}


/*
public class ComputerPlayer extends Player {

    private Strategy strategy;

    public ComputerPlayer(Mark mark) {
        this(mark, new NaiveStrategy());
    }

    public ComputerPlayer(Mark mark, Strategy s) {
    super("Computer", mark);
    this.strategy = s;
    }
    @Override
    public int determineMove(Board board) {
        int move = strategy.determineMove(board, getMark());
        System.out.println(getName() + " chose " + move);

        return move;
    }
}
*/