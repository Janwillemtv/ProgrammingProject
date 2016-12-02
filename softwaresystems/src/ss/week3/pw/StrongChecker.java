package week3.pw;

/**
 * Created by janwillem on 12/2/16.
 */
public class StrongChecker extends BasicChecker implements ss.week3.pw.Checker{

    public StrongChecker(){

    }

    boolean acceptable(String s){
        if(s.length() >= 6 && !s.contains(" ")){
            Character c = s.charAt(0);

            if(Character.isLetter(s.charAt(0)) && Character.isDigit(s.charAt(s.length()-1)) ){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    String generatePassword(){
        return "Raspberry1";
    }

}
