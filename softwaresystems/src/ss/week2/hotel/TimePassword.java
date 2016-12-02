package ss.week2.hotel;

import static java.lang.System.currentTimeMillis;

/**
 * Created by janwillem on 12/2/16.
 */
public class TimePassword extends Password {
    private int validTime;

    public TimePassword(int time){
        super();
        validTime = (int) (currentTimeMillis() + time);
    }

    public TimePassword(){
        super();
        validTime = (int) (currentTimeMillis() + 10000);
    }

    public boolean isExpired() {
        if(currentTimeMillis() > validTime){
            return true;
        }else{
            return false;
        }
    }
}
