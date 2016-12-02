package ss.week3.pw;

/**
 * Created by janwillem on 12/2/16.
 */
public class BasicChecker implements Checker{
    public static final String INITPASS = "raspberry";

    public BasicChecker(){

    }

    public boolean acceptable(String s){
        if(s.length() >= 6 && !s.contains(" ")){
            return true;
        }else {
            return false;
        }

    }

    public String generatePassword(){
        return (INITPASS);
    }

}