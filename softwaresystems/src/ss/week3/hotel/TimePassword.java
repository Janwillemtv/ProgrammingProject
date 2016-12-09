package ss.week3.hotel;

import static java.lang.System.currentTimeMillis;

/**
 * Created by janwillem on 12/2/16.
 */
public class TimePassword extends Password {
    private int validTime;
    private long expired;
    public static final int INITTIME = 1000;

    public TimePassword(int time){
        super();
        validTime = time;
        expired =  currentTimeMillis() + validTime;
    }

    public TimePassword(){
        this(INITTIME);
    }

    public boolean isExpired() {
        if(currentTimeMillis() > expired){
            return true;
        }else{
            return false;
        }
    }

    public void restart() {
        expired = currentTimeMillis() + validTime;
    }
}
