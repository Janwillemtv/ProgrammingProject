package ss.week5.tictactoe;

/**
 * Created by Tom on 19-12-2016.
 */


public class ComputerPlayer extends Player {

    public Strategy strategy;
    public int difficulty;

    public ComputerPlayer(String n, Mark m, int difficulty) {
        this(n, m);
        this.difficulty = difficulty;
    }
    public ComputerPlayer(String n, Mark m) {
        super (n, m);
       // super (, m);
        switch (n) {
            case "-N":
                strategy = new NaiveStrategy(n);
                System.out.println("There is a dumb player:");
                break;
            case "Smart":
                strategy = new SmartStrategy(n);
                System.out.println("There is a smart player");
                break;
            case "HAL9000":
                strategy = new SuperStrategy(n, difficulty);
                System.out.println("I'm afraid I cant do that");
                break;
            default:
                strategy = new NaiveStrategy(n);
                System.out.println("There is a dumb player:");
                //do nothing yet
                break;
        }
    }
    @Override
    public int determineMove(Board board) {
       // Board thisBoard = board.deepCopy();
       // int choice = strategy.determineMove(board, getMark());
       // System.out.println("Strategy =" + strategy.determineMove(board, getMark()));
        System.out.println(strategy.getName() + " Played: " + strategy.determineMove(board, getMark()));
        return strategy.determineMove(board, getMark());
    }
}
/*
public class ComputerPlayer extends Player {

    private Strategy strategy;

    public ComputerPlayer(Mark mark, String s) {
        switch (s) {
            case "-N":
                this(mark, new NaiveStrategy());
                break;
            case "HAL":
                this(mark, new SmartStrategy());
                break;
            default:
                this(mark, new NaiveStrategy());
        }
       // this(mark, new NaiveStrategy());
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
}*/