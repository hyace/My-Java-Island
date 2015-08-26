package algorithms;

/**
 * Created by Chyace on 2015/8/5.
 * Including：
 * Quicksort
 */
public class Sorting {
    /**
     * public API of Quicksort
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable> void quicksort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quicksort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable> void quicksort(T[] arr, int left, int right) {
        int p = left, i = left, j = right;
        T temp = arr[left];
        while (i <= j) {
            while (p <= j && temp.compareTo(arr[j]) <= 0) {
                j--;
            }
            if (p <= j) {
                arr[p] = arr[j];
                p = j;
            }
            while (p >= i && temp.compareTo(arr[i]) >= 0) {
                i++;
            }
            if (p >= i) {
                arr[p] = arr[i];
                p = i;
            }
        }
        arr[p] = temp;
        if (p - 1 > left) {
            quicksort(arr, left, p - 1);
        }
        if (p + 1 < right) {
            quicksort(arr, p + 1, right);
        }
    }

    /**
     * public API of Bubblesort
     */
    public static <T extends Comparable> void bubblesort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    private static <T> void swap(T[] arr, int j, int i) {
        T temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static <T extends Comparable> void mergesort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        mergesort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable> void mergesort(T[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergesort(arr, left, mid);
        mergesort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static <T extends Comparable> void merge(T[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1;
        Object[] temp = new Object[right - left + 1];
        int p;
        for (p = 0; p < temp.length; p++) {
            if (i > mid) {
                temp[p] = arr[j++];
            } else if (j > right) {
                temp[p] = arr[i++];
            } else if (arr[i].compareTo(arr[j]) <= 0) {
                temp[p] = arr[i++];
            } else {
                temp[p] = arr[j++];
            }
        }
        p--;
        while (p > 0) {
            arr[left + p] = (T) temp[p--];
        }
    }
}
