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
     * �����⣺һ��HashMap��ô�ܱ�ֻ֤��100��Ԫ��
     * ������LinkedHashMap��ʵ��LRU
     * ��ϤLinkedHashMap��
     * ���췽��
     * LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
     * ��ʼ����
     * �������ӣ��ﵽ��������ʱ���ݣ�����rehash����ϣ������Լ������Ͱ��Ĭ��.75
     * ����ģʽ ����˳�� true������˳�� false����������ǹ���LRU�Ĺؼ������Ϊfalse����ô��ֻ�ǰ��ղ���˳
     ***
     * HashMap
     * Key Value ������Ϊnull
     * ��ͬ��
     * ��������������HashTable������
     **
     * ����������get��put��Ϊ����ʱ��
     * *
     * HashMap�е�table��lengthΪ����size����С2��n����
     * HashMap�еķ���indexFor ����Ͱ��λ�ã����� h & length-1���൱��h%length
     * *
     * �������������Ҫ��Ͱ��������ߣ����Ӳ��ɹ��ͣ�
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
