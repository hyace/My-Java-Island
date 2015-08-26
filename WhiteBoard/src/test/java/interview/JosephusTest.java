package interview;

import org.junit.Test;

/**
 * Created by Chyace on 2015/8/26.
 */
public class JosephusTest {
    private static final int MAX = 8;

    @Test
    public void josephusTest() {
        int[] arr = new int[MAX];
        for (int i = 1; i < MAX + 1; i++) {
            arr[i - 1] = i;
        }
        int r = Solution.josephus(MAX, 2);
        System.out.println(arr[r]);
    }
}
