package practice.concurrency;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Author: 张晖
 * MIS: zhanghui20
 * Date: 16/2/18
 * Email: zhanghui20@meituan.com
 */
public class ThreadpoolTest {
    private List<Integer> base;

    @Before
    public void init() {
        base = Lists.newArrayList();
        for (int i = 1; i < 1000; i++) {
//            int num = new Random().nextInt(200);
            base.add(i);
        }
    }

    @Test
    public void threadlocalTest() {
        ExecutorService executor = Executors.newFixedThreadPool(10);

    }

    @Test
    public void calculateSingle() throws InterruptedException {
        long sum = 0;
        for (Integer i : base) {
            sum += (long) i;
            Thread.sleep(1);
        }
        System.out.println(sum);
        System.out.println((int) (1.227 * 100) / (double) 100);
    }

    @Test
    public void calculateRunable() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        final AtomicLong atomicLong = new AtomicLong();
        final CountDownLatch latch = new CountDownLatch(base.size());
        for (final int i : base) {
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1);
                        atomicLong.addAndGet((long) i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }
        latch.await();
        System.out.println(atomicLong.toString());
    }

    @Test
    public void calculateThreadpool() {
        ExecutorService executorService = new ThreadPoolExecutor(100, 100, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        List<Future<AtomicLong>> futures = Lists.newArrayList();
        final BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<Integer>(base);
        for (int i = 0; i < 100; i++) {
            Future<AtomicLong> future = executorService.submit(new Callable<AtomicLong>() {
                public AtomicLong call() throws Exception {
                    AtomicLong atomicLong = new AtomicLong();
                    while (!blockingDeque.isEmpty()) {
                        Thread.sleep(1);
                        atomicLong.addAndGet(blockingDeque.poll());
                    }
                    return atomicLong;
                }
            });
            futures.add(future);
        }
        long sum = 0;
        while (!futures.isEmpty()) {
            System.out.println(futures.size());
            try {
                sum += futures.get(0).get(100, TimeUnit.MILLISECONDS).longValue();
                futures.remove(0);
            } catch (InterruptedException e) {
                futures.remove(0);
                e.printStackTrace();
            } catch (ExecutionException e) {
                futures.remove(0);
                e.printStackTrace();
            } catch (TimeoutException e) {
            }
        }
        System.out.println(sum);

    }
}
