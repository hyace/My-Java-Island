package notes;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class Chapter1 {
    private long countPlain = 0;
    private final AtomicLong countAtomic = new AtomicLong(0);

    /**
     * Title: Test Executors
     * Date: 2015.07.01
     * site: http://www.infoq.com/cn/articles/executor-framework-thread-pool-task-execution-part-01
     * Note:
     * * Callable接口类似于Runnable，但是没有返回结果，无法抛出经过检查的异常。
     *
     */
    @Test
    public void executorsTest() throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        String outputs = exec.submit(new Callable<String>() {
            public String call() throws Exception {
                System.out.println("count plain: "+countPlain++);
                return "copy!";
            }
        }).get();
        System.out.println(outputs);
    }
}
