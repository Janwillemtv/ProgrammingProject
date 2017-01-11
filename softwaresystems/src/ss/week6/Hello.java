package ss.week6;

import java.util.Scanner;

/**
 * Created by janwillem on 12/20/16.
 */
public class Hello {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Hello, what is your name?");
        while(in.hasNext()){
            System.out.print("Hello " + in.next());
        }

    }


}
