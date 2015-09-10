package practice;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Chyace on 2015/9/10.
 */
public class IncreaceTest {
    private static final int THREADS_COUNT = 200;
    public static int race = 0;
    public static volatile int raceV = 0;
    public static AtomicInteger raceA = new AtomicInteger(0);

    public static void increase() {
        race++;
        raceV++;
        raceA.incrementAndGet();
    }

    public static synchronized void increaseSyn() {
        race++;
        raceV++;
        raceA.incrementAndGet();
    }

    @Test
    public void increaseRaw() {
        for (int i = 0; i < THREADS_COUNT; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
//                        increaseSyn();
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println("race: " + race);
        System.out.println("raceV: " + raceV);
        System.out.println("raceA: " + raceA);
    }
}
