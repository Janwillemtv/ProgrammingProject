package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Tom on 16-1-2017.
 */
public class FinegrainedIntCell implements IntCell {
    private Lock l;
    private Condition canWrite;
    private Condition canRead;
    private int value;
    private boolean write;

    public FinegrainedIntCell(){
        l =  new ReentrantLock();
        canWrite =  l.newCondition();
        canRead = l.newCondition();
        value = 0;
        write = false;
    }

    @Override
    public void setValue(int valueArg) {
        l.lock();


            try {
                while (write) {
                    canWrite.await();
                }
                //System.out.println(value);
                this.value = valueArg;
                this.write = true;
                canRead.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                l.unlock();
            }

    }
    @Override
    public int getValue() {
        l.lock();

        try {
            while (!write) {
                canRead.await();

            }
            this.write = false;
            canWrite.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            l.unlock();
        }
        return value;
    }
        // System.out.println(value);
}
