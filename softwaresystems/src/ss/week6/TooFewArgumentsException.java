package ss.week6;

/**
 * Created by Tom on 20-12-2016.
 */
public class TooFewArgumentsException extends WrongArgumentException {

    public String getMessage() {
        return "error: must pass two command line arguments";
    }

}
