package interview;

/**
 * Created by Chyace on 2015/9/10.
 */
public class FindTopN {
    /**
     * 用快排步骤进行查找
     */
    public static void quickFind(int[] arr, int n) {
        quickFind(arr, 0, arr.length, n);
    }

    private static void quickFind(int[] arr, int left, int right, int n) {
        int p = left, q = right;
        int v = arr[p];
        while (p < q) {
            while (p < q && arr[p] < v) {
                p++;
            }
            while (q > p && arr[q] >= v) {
                q--;
            }
            if (p < q) {
                swap(arr, p, q);
            }
        }
        //TODO
//        if(arr.length-q)
    }

    private static void swap(int[] arr, int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}
