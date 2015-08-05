package algorithms;

import org.junit.Before;
import org.junit.Test;
import util.Print;

import java.util.Random;

/**
 * Created by Chyace on 2015/8/5.
 */
public class SortingTest {
    Integer[] arr;
    @Before
    public void dataPrepare(){
        arr = new Integer[3000000];
        for(int i = 0;i<3000000;i++){
            arr[i] = new Random().nextInt(100000000);
        }
    }
    @Test
    public void quicksortTest(){
//        Print.printArray(arr);
        //2M数据 5s
        Sorting.quicksort(arr);
//        Print.printArray(arr);
    }
    @Test
    public void bubblesortTest(){
//        Print.printArray(arr);
        //20K数据 5s
        Sorting.bubblesort(arr);
//        Print.printArray(arr);
    }
    @Test
    public void mergesortTest(){
//        Print.printArray(arr);
        //3M数据 5s
        Sorting.mergesort(arr);
//        Print.printArray(arr);
    }
}
