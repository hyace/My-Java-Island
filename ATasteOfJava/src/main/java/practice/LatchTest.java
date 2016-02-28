package practice;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hyace on 16/1/21.
 */
public class LatchTest {
    private static final int FIXED = 10;
    private static final int MAX = 100;
    private AtomicInteger count = new AtomicInteger(0);
    private List<Integer> content = new ArrayList<Integer>();
    private long startTime;

    @Before
    public void before() {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
            content.add(i);
        }
        perid();
    }

    private void perid() {
        long delta = System.currentTimeMillis() - startTime;
        System.out.println("历时："+delta/1000+"s");
    }

    @Test
    public void countdownTest() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(FIXED);
        long total = 0;
        final CountDownLatch latch = new CountDownLatch(MAX);
        for (final Integer i : content) {
            service.execute(new Runnable() {
                public void run() {
                    try {
                        count.addAndGet(1);
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.getMessage();
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }
        latch.await();
        System.out.println("Main Thread: " + Thread.currentThread().getName() + "is OVER! ");
    }

    @Test
    public void singleTest() {
        for (final Integer i : content) {
            count.addAndGet(1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count+": Calculate: " + Thread.currentThread().getName() + " Num: " + i);
        }
        System.out.println("Main Thread: " + Thread.currentThread().getName() + "is OVER! ");
    }
}
