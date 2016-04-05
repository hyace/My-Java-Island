package practice.concurrency;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: 张晖
 * MIS: zhanghui20
 * Date: 16/3/28
 * Email: zhanghui20@meituan.com
 */
public class FutureTest {
    private static final AtomicInteger INC = new AtomicInteger();
    private final BlockingDeque<Integer> num = Queues.newLinkedBlockingDeque();

    @Test
    public void listTest() {
        List<String> list = Lists.newArrayListWithCapacity(100);
        System.out.println(list.size() + " , " + list.isEmpty());
    }

    @Test
    public void blockQTest() {
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            executor.submit(new Runnable() {
                public void run() {
                    fill(num);
                }
            });
        }
        int sum = 0;
        while (true) {
            try {
                Integer i = num.poll(100, TimeUnit.MILLISECONDS);
                if (i == null) {
                    break;
                }
                sum += i;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
        System.out.println(Double.MAX_VALUE);
    }

    @Test
    public void futureTest() {
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        List<Future<Boolean>> futures = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            Future<Boolean> future = executor.submit(new Callable<Boolean>() {
                public Boolean call() throws Exception {
                    fill(num);
                    return true;
                }
            });
            futures.add(future);
        }
        while (!futures.isEmpty()) {
            Future<Boolean> future = futures.get(0);
            try {
                future.get(100, TimeUnit.MILLISECONDS);
                futures.remove(future);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        int sum = 0;
        for (Integer i : num) {
            sum += i;
        }
        System.out.println(sum);
    }

    @Test
    public void normal() {
        for (int i = 0; i < 1000; i++) {
            fill(num);
        }

        int sum = 0;
        for (Integer i : num) {
            sum += i;
        }
        System.out.println(sum);

    }

    private void fill(BlockingDeque<Integer> num) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            num.put(INC.incrementAndGet());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
