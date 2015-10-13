package interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Hyace on 2015/9/13.
 */
public class DoubleThread implements Runnable {
    int cont;
    Class lock = DoubleThread.class;
    static AtomicInteger count = new AtomicInteger();

    public DoubleThread(int cont) {
        this.cont = cont;
    }

    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    lock.notify();
                    lock.wait();
                    System.out.println("line: " + count + ", content: " + cont);
                    count.incrementAndGet();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new DoubleThread(1));
        Thread t2 = new Thread(new DoubleThread(2));
        t1.start();
        t2.start();
//        t1.run();
    }
}
