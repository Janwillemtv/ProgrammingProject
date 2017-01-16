package ss.week7.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Tom on 16-1-2017.
 */
public class TestSyncConsole extends Thread {
    int threadID;
    private Lock lock;

    TestSyncConsole(int threadNumber, Lock l) {
        threadID = threadNumber;
        this.lock = l;
    }
    synchronized private void sum() {
        lock.lock();
        try {
            int first = Console.readInt("Number 1");
            int second = Console.readInt("Number 2");
            int sum = first + second;
            Console.println(threadID + " " + sum + "");
        } finally {
            lock.unlock();
        }
    }
    synchronized public void run() {
        this.sum();
    }
    public static void main(String[] args) {
        Lock l = new ReentrantLock();
        TestSyncConsole Test1 = new TestSyncConsole(1, l);
        TestSyncConsole Test2 = new TestSyncConsole(2, l);

        Test1.start();
        Test2.start();

    }
}

