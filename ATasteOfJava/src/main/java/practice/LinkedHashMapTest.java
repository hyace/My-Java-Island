package practice;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Chyace on 2015/7/27.
 */
public class LinkedHashMapTest {

    /**
     * 笔试题：一个HashMap怎么能保证只存100个元素
     * 考虑用LinkedHashMap来实现LRU
     * 熟悉LinkedHashMap：
     * 构造方法
     * LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
     * 初始容量
     * 加载因子，达到容量比例时扩容，进行rehash，哈希表将具有约两倍的桶，默认.75
     * 排序模式 访问顺序 true，插入顺序 false，这个参数是构成LRU的关键，如果为false，那么就只是按照插入顺
     ***
     * HashMap
     * Key Value 都可以为null
     * 非同步
     * 以上两点是其与HashTable的区别
     **
     * 基本操作（get、put）为常数时间
     * *
     * HashMap中的table的length为大于size的最小2的n次幂
     * HashMap中的方法indexFor 计算桶的位置，用了 h & length-1，相当于h%length
     * *
     * 如果迭代性能重要，桶不可设过高，因子不可过低，
     *
     */
    @Test
    public void interview2() {
        final int MAX_ENTRIES = 10;
        HashMap<String, String> map = new LinkedHashMap<String, String>(MAX_ENTRIES, .75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > MAX_ENTRIES;
            }
        };
        for (int i = 0; i < 9; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
        map.put("9", "9");
        map.put("4", "4");
        map.put("7", "7");
        map.put("1", "1");
        map.put("10", "10");
        map.put("11", "11");
        map.put("7", "7");
        System.out.println(map);
    }


}
