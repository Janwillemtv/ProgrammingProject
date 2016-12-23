package ss.week6;

/**
 * Created by Tom on 20-12-2016.
 */
public class ArgumentLengthsDifferException extends WrongArgumentException {
    private int l1, l2;
    public String getMessage() {
        return "error: length of command line arguments "
                + "differs (" + l1 + ", " + l2 + ")";
    }
    ArgumentLengthsDifferException(int a, int b) {
        l1 = a;
        l2 = b;
        System.out.println("error: length of command line arguments "
                + "differs (" + a + ", " + b + ")");
    }
}
