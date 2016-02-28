package practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hyace on 16/1/15.
 */
public class ShuffleNSub {
    @Test
    public void test(){
        List<String> list = new ArrayList<String>();
        for(int i = 0;i<15;i++){
            list.add(String.valueOf(i));
        }
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        list = list.subList(0, 5);
        System.out.println(list);
    }
}
