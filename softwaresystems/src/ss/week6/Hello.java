package ss.week6;
import java.util.Scanner;
/**
 * Created by Tom on 20-12-2016.
 */
public class Hello {
    Scanner in;
    public String WelcomeMessage = "Hello";

    Hello() {
        in = new Scanner(System.in);
    }
    public void provideName(Scanner input) {
        System.out.println("Please provide your name");
    }
    public static void main(String[] args) {

    }
}
