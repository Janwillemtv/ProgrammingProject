package ss.week6;

import java.util.Scanner;

/**
 * Created by janwillem on 12/20/16.
 */
public class Words {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("please enter sentence");
        int i = 1;
        boolean first = true;

        while(in.hasNext()){
            if(first) {
                System.out.println("Line: ");
                first = false;
            }
            String output = in.next();
            if(output.equals("end")){
                System.out.println("End");
                System.out.println("End of programme");
                break;
            }
            System.out.println("Word "+ i + ": " + output);
            i++;

        }
    }
}
