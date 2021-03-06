package ss.week7.account;

/**
 * Created by Tom on 16-1-2017.
 */
public class MyThread extends Thread {

    private final double theAmount;
    private final int theFrequency;
    private final Account theAccount;

    public MyThread(double amount, int frequency, Account account) {
        this.theAmount = amount;
        this.theFrequency = frequency;
        this.theAccount = account;


    }
    public void run() {
     for(int i = 0; i < theFrequency; i++){
         theAccount.transaction(theAmount);
         System.out.println("Balance " + theAccount.getBalance());
     }

    }
}
