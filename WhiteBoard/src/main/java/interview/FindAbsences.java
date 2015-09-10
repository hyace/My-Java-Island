package interview;

import java.util.List;

/**
 * Created by Chyace on 2015/9/9.
 * An array contains numbers range from 1 to n, its size is n. Find the absent numbers .
 */

public class FindAbsences {
    public static void find(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = i;
            if (arr[temp] != 0) {
                temp = arr[temp] - 1;
                if (temp < 0) {
                    continue;
                }
                while (arr[temp] != 0) {
                    int t = arr[temp] - 1;
                    arr[temp] = 0;
                    temp = t;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}
