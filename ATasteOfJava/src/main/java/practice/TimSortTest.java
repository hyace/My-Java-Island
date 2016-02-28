package practice;

import org.junit.Test;

import java.util.*;

/**
 * Created by hyace on 16/1/12.
 */
public class TimSortTest {
    @Test
    public void intSort() {
        List raw = new ArrayList();
        for (int i = 0; i < 20; i++) {
            int cur = new Random().nextInt(20);
            raw.add(cur);
        }
        printArray(raw);
        Collections.sort(raw);
        printArray(raw);
    }

    @Test
    public void objectSort() {
        List raw = new ArrayList();
        for (int i = 0; i < 50; i++) {
            int cur = new Random().nextInt(100);
            Unit u = new Unit();
            u.name = "0";
            u.value = cur;
            raw.add(u);
        }
//        printArray(raw);
        try {
            Collections.sort(raw, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Unit u1 = (Unit) o1;
                    Unit u2 = (Unit) o2;
                    return u1.value > u2.value ? 1 : -1;
//                return u1.value > u2.value ? 1 : u1.value.equals(u2.value) ? 0 : -1;
                }
            });
        } catch (IllegalArgumentException e) {
            System.out.println("###################");
            e.printStackTrace();
            printArray(raw);
            System.exit(-1);
        }
//        printArray(raw);
    }

    /**
     * 因为是用timsort，所以比较器不严格合规的话会抛出 java.lang.IllegalArgumentException: Comparison method violates its general contract
     */
    @Test
    public void circle() {
        for (int i = 0; i < 100000; i++) {
            objectSort();
//            uniqueTest();
        }
    }

    @Test
    public void uniqueTest() {
        String data = "28 80 32 73 35 70 4 54 88 31 1 67 32 44 88 28 81 74 51 62 38 0 84 19 37 13 76 80 85 12 98 29 3 14 44 4 9 23 43 63 13 90 16 13 21 1 40 67 31 40";
        String[] datas = data.split(" ");
        List raw = new ArrayList();
        for (String s : datas) {
            int i = Integer.parseInt(s);
            raw.add(i);
        }
//        printArray(raw);
        Collections.sort(raw);
        try {
            Collections.sort(raw, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o1 > o2 ? 1 : -1;
//                return u1.value > u2.value ? 1 : u1.value.equals(u2.value) ? 0 : -1;
                }
            });
        } catch (IllegalArgumentException e) {
            System.out.println("###################");
            printArray(raw);
            System.exit(-1);
        }
//        printArray(raw);
    }

    private void printArray(List list) {
        for (Object i : list) {
            if (i instanceof Integer) {
                System.out.print(i + " ");
            } else if (i instanceof Unit) {
                Unit u = (Unit) i;
                System.out.print(u.value + " ");
            }
        }
        System.out.println();
    }
}

class Unit {
    String name;
    Integer value;
}
