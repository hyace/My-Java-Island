package practice;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;
import org.junit.Test;

import java.util.*;
import java.util.Map.Entry;

/**
 * Created by Chyace on 2015/8/6.
 */
public class InheritTest {
    @Test
    public void inheritTest() {
        // 1.7以后是可以不加泛型的，但是当不加时，就需要在for迭代中用Object类型，
        // 因为集合是Object的，否则类型不匹配
        LinkedHashMap<String, String> lh = new LinkedHashMap();
        lh.put("1", "ONE");
        lh.put("2", "TWO");
        lh.put("3", "THREE");
        for (Entry e : lh.entrySet()) {
            System.out.println(e);
        }
        List list = new ArrayList();
        list.add(new Sub());
        list.add(new Sub());
        list.add(new Sub());
        list.add(new Sub());
        for(Object s:list){}
        methodTest(list);
    }
class Base{}
class Sub extends Base{}
    private void methodTest(List<HashMap> list) {
        for (HashMap h : list) {
//            for(Entry e: h.entrySet()){
//
//            }
        }
    }
}
