package ss.week7.account;

import sun.management.counter.AbstractCounter;

/**
 * Created by Tom on 16-1-2017.
 */
public class AccountSync {

    public static void main(String[] args) {
        Account account = new Account();
        Thread myThread = new MyThread(9.0, 1000, account);
        Thread myThread2 = new MyThread(-9.0, 1000, account);

        myThread.start();
        myThread2.start();

        try {
            myThread.join();
            myThread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Balance: " + account.getBalance());
    }
}
