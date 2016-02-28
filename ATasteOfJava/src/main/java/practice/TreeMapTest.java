package practice;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by hyace on 16/1/25.
 */
public class TreeMapTest {
    @Test
    public void sortTest(){
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        for(int i = 0;i<10;i++){
            int num = new Random().nextInt(100);
            map.put(num, String.valueOf(100-num));
            map.put(num, String.valueOf(100-num));
        }
        for(Map.Entry<Integer, String> en : map.entrySet()){
            System.out.println(en);
        }
    }
    @Test
    public void sortBigDecimal(){
        TreeMap<BigDecimal, String> map = new TreeMap<BigDecimal, String>();
        map.put(BigDecimal.valueOf(2.44), "2.44");
        map.put(BigDecimal.valueOf(3.6), "3.6");
        map.put(BigDecimal.valueOf(0.56), "0.56");
        map.put(BigDecimal.valueOf(9.08), "9.08");
        map.put(BigDecimal.valueOf(2.44), "2.440");
        for(Map.Entry<BigDecimal,String> en:map.entrySet()){
            System.out.println(en);
        }
    }

}
