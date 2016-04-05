package practice;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: 张晖
 * MIS: zhanghui20
 * Date: 16/2/19
 * Email: zhanghui20@meituan.com
 */
public class HashTest {
    @Test
    public void sizeTest(){
        int size = 20000000;
        //完全没意义。。。因为会缩
//        Map<Integer, Object> map = Maps.newHashMapWithExpectedSize(2*size);
        Map<Integer, Object> map = new HashMap<Integer, Object>(2*size);
        for(int i = 0;i<size;i++){
            map.put(i,new Object());
        }
        System.out.println(map.get(3224));
        System.out.println(map.get(-11));
    }
    @Test
    public void nullTest(){
//        System.out.println(get(3));
//        System.out.println(get(6));
//        System.out.println(new Integer(40000).shortValue());
//        if(get(8)==1){
//            System.out.println("Success");
//        }
        System.out.println((int)Math.ceil((double)14/7));
    }
    private Integer get(int o){
        if(o%2==1)return 1;
        return null;
    }
    @Test
    public void initTest(){
        final Map<String, AtomicInteger> map = ImmutableMap.of(
                "one", new AtomicInteger(),
                "two", new AtomicInteger()
                );
        ExecutorService service = Executors.newFixedThreadPool(10);
        final CountDownLatch latch = new CountDownLatch(100);
        for(int i = 1;i<=100;i++){
            final int para = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        map.get("one").addAndGet(para);
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(map.get("one").intValue());
        System.out.println(map.get("two").intValue());
    }
}
