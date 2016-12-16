package ss.week4.tictactoe;

import java.util.Scanner;
import java.io.IOException;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
        // TODO: implement, see P-4.21
    Scanner scanner = new Scanner(System.in);

    String name1 = (args.length > 0 && args[0] != null) ? args[0] : "unnamed";
    String name2 = (args.length > 1 && args[1] != null) ? args[1] : "unnamed";

    HumanPlayer p1 = new HumanPlayer(name1, Mark.XX);
    p1.setScanner(scanner);

    HumanPlayer p2 = new HumanPlayer(name2, Mark.OO);
    p2.setScanner(scanner);

    Game game = new Game(p1, p2);
    game.setScanner(scanner);
    game.start();
    }
}
