package ss.week7.threads;

/**
 * Created by Tom on 16-1-2017.
 */
public class SynchronizedIntCell implements IntCell {
    private int value = 0;

    private boolean write = false;

    public synchronized void setValue(int valueArg) {

        this.value = valueArg;
        while (write) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(value);
        this.value = valueArg;
        this.write = true;
        notifyAll();
    }

    public synchronized int getValue() {

        while (!write) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       // System.out.println(value);

        this.write = false;
        notifyAll();
        return value;

    }


}
