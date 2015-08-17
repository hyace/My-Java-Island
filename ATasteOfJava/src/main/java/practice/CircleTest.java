package practice;

import org.junit.Test;

/**
 * Created by Chyace on 2015/7/21.
 */
public class CircleTest {
    @Test
    public void interview1() {
        /*
        笔试题：见方法
         */
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
        circle(arr);
        /*
        笔试题: 以下代码如何输出
         */
        int c = 1, b = 1;
        c = c++;
        b++;
        System.out.println(c + " " + b);
    }

    /**
     * 一个数组，从第一个开始隔一个输出、删除，循环往复，输出顺序。
     *
     * @param arr
     */
    void circle(int[] arr) {
        int n = arr.length;
        int count = 0;
        int s = 0, p = 0, r = 0;

        while (count < n) {
            if (arr[p] > Integer.MIN_VALUE) {
                if (s == 0) {
                    System.out.print(arr[p] + " ");
                    arr[p] = Integer.MIN_VALUE;
                    count++;
                    s = 1;
                } else {
                    s = 0;
                }
            }
            p = (p + 1) % n;
            r++;
        }
        System.out.println();
        System.out.println(r);
    }

}
