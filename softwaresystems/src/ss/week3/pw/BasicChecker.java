package week3.pw;

/**
 * Created by janwillem on 12/2/16.
 */
public class BasicChecker implements ss.week3.pw.Checker{

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
        return ("raspberry");
    }

}
