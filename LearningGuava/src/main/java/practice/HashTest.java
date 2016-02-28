package practice;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
    }
}
