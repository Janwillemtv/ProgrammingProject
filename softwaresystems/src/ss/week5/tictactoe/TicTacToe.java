package ss.week5.tictactoe;

import java.util.Scanner;

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

    String name1 = (args.length > 0 && args[0] != null) ? args[0] : "Tom";
    String name2 = (args.length > 1 && args[1] != null) ? args[1] : "Smart";
    HumanPlayer p1 = new HumanPlayer(name1, Mark.XX);
    //ComputerPlayer p1 = new ComputerPlayer(name1, Mark.XX);
    p1.setScanner(scanner);
    Player p2;
    switch(name2) {
        case "-N": case "Smart": case "HAL9000":
            p2 = new ComputerPlayer(name2, Mark.OO);
            break;
        default:
            p2 = new HumanPlayer(name2, Mark.OO);
            p2.setScanner(scanner);
            break;
    }
    //HumanPlayer p2 = new HumanPlayer(name2, Mark.OO);
    //p2.setScanner(scanner);

    Game game = new Game(p1, p2);
    game.setScanner(scanner);
    game.start();
    }
}
