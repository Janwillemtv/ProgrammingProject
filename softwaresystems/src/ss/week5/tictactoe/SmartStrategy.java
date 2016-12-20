package ss.week5.tictactoe;
import java.util.*;
/**
 * Created by Tom on 19-12-2016.
 */
public class SmartStrategy implements Strategy {
    String strategyName;

    SmartStrategy(String n) {
        strategyName = n;
    }
    public String getName() {
        return strategyName;
    }
    public int determineMove(Board b, Mark m) {
        int out = -1;
        Board B = b.deepCopy();
        while (out == -1) {
           // System.out.println("I have no idea what I'm doing");
            int randNumber = (int)(Math.random()* B.size());
            //make a choice
            out = B.isEmptyField(randNumber) ? randNumber : -1;
        }
        out = checkWin(B, m.other()) == -1 ? out : checkWin(B, m.other());
        out = checkWin(B, m) == -1 ? out : checkWin(B, m);
        out = B.getField(4) == m.EE ? 4 : out;
        return out;
    }
    private int checkHorizontalWin(Board b, Mark m) {
        int out = -1;
        for (int i =0; i < b.DIM; i++) {
            int n = 0;
            int toPlace = -1;
            for (int j = 0; j < b.DIM; j++) {
                n += b.getField(i, j) == m ? 1 : 0;
                toPlace = b.getField(i, j) == m.EE ? (i * b.DIM) + j : toPlace;
            }
            out = n == b.DIM-1 && toPlace != -1 ? toPlace : -1;
            //System.out.println(out);
            if (out!= -1) {
               // System.out.println("There is a horizontal win visible");
                break;
            }
        }
        return out;
    }
    private int checkVerticalWin(Board b, Mark m) {
        int out = -1;
        for (int i =0; i < b.DIM; i++) {
            int n = 0;
            int toPlace = -1;
            for (int j = 0; j < b.DIM; j++) {
                n += b.getField(j, i) == m ? 1 : 0;
                toPlace = b.getField(j, i) == m.EE ? (j * b.DIM) + i : toPlace;
            }
            out = n == b.DIM-1 && toPlace != -1 ? toPlace : -1;
           // System.out.println(out);
            if (out!= -1) {
              //  System.out.println("There is a vertical win visible");
                break;
            }
        }
        return out;
    }
    private int checkDiagonalWin(Board b, Mark m) {
        int out = -1;
        // it is 2 because there are only two ways to win, regardless of the board size
        //4 in  row requires 4 to win. 5, 5 etc...
        for (int i = 0; i < 2; i++) {
            int n = 0;
            int toPlace = -1;
            for (int j = 0; j < b.DIM; j++) {
                int index = num(i, j, b.DIM);
                n += b.getField(index) == m ? 1 : 0;
                toPlace = b.getField(index) == m.EE ? index : toPlace;
            }
            out = n == b.DIM-1 && toPlace != -1 ? toPlace : -1;
          //  System.out.println(out);
            if (out != -1) {
             //   System.out.println("There is a diagonal win visible");
             //   System.out.println("therefore we block it like this: " + out);
                break;
            }
        }
        return out;
    }
    //d = direction, i = index, size = size of board
    private int num(int d, int i, int size) {
        int adder = d == 0 ? 4 : -2;
        //TODO implement good starting algorithm
        int start = 0;
        if (d == 1) {
            for (int n = 0; n < size; n++) {
                start += n * 2;
            }
        }
        return start + (adder * i);
    }
    private int checkWin(Board b, Mark m) {
        int out = -1;
        out = checkHorizontalWin(b, m) == -1 ? out : checkHorizontalWin(b, m);
        out = checkVerticalWin(b, m) == -1 ? out : checkVerticalWin(b, m);
        out = checkDiagonalWin(b, m) == -1 ? out : checkDiagonalWin(b, m);
        return out;
    }
}
