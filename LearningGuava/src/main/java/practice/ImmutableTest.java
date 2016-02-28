package practice;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import org.junit.Test;

import java.util.*;

/**
 * Author: 张晖
 * MIS: zhanghui20
 * Date: 16/1/25
 * Email: zhanghui20@meituan.com
 */
public class ImmutableTest {
    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    @Test
    public void mapTest(){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<10;i++){
            int num = new Random().nextInt(20);
            list.add(num);
        }
        for(Integer i : list){
            System.out.print(i + " ");
        }
        Collections.sort(list);
        System.out.println();
        for(Integer i : list){
            System.out.print(i + " ");
        }
        System.out.println();
        int num = 0;
        for(Integer i : list){
            map.put(i, num++);
        }
        float f = 5/Float.parseFloat(0+"");
        System.out.println(f);
        final ImmutableMap<Integer,Integer> im = ImmutableMap.copyOf(map);
        for(Map.Entry<Integer, Integer> en : im.entrySet()){
            System.out.println(en);
        }
        System.out.println(f);
        ImmutableSortedMap<Integer, Integer> ism = ImmutableSortedMap.copyOf(map);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry);
        }
        System.out.println(f);
        for(Map.Entry<Integer, Integer> entry : ism.entrySet()){
            System.out.println(entry);
        }
        System.out.println((-11)/3);
    }
}
