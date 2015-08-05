package util;

/**
 * Created by Chyace on 2015/8/5.
 */
public class Print {
    public static <T> void printArray(T[] arr){
        if(arr == null && arr.length==0){
            System.out.println("Blank Array ! ");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(T item : arr){
            sb.append(item+" ");
        }
        sb.append("]");
        System.out.println(sb);
    }
}
