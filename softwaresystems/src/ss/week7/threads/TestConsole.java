package ss.week7.threads;

/**
 * Created by Tom on 16-1-2017.
 */
public class TestConsole extends Thread {
    int threadID;
    TestConsole(int threadNumber) {
        threadID = threadNumber;
    }
    private void sum() {
      int first = Console.readInt("Number 1");
      int second = Console.readInt("Number 2");
        int sum = first + second;
        Console.println(threadID + " " + sum + "");
    }
    public void run() {
        this.sum();
    }
    public static void main(String[] args) {
        TestConsole Test1 = new TestConsole(1);
        TestConsole Test2 = new TestConsole(2);

        Test1.start();
        Test2.start();

    }
}
