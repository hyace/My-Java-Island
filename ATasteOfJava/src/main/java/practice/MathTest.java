package practice;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.zip.CRC32;

/**
 * Author: 张晖
 * MIS: zhanghui20
 * Date: 16/2/20
 * Email: zhanghui20@meituan.com
 */
public class MathTest {
    final static long NUM = 10000000;

    @Test
    public void decimalTest(){
        double result = 0;
        for(long i = 0;i<NUM;i++){
            result = 13232/(double)523;
            result = Double.parseDouble(String.format("%.4f", result));
        }
        System.out.println(result);
    }
    @Test
    public void bigdecimalTest(){
        double result = 0;
        for(long i = 0;i<NUM;i++){
            result = new BigDecimal(13232).divide(new BigDecimal(523), 4, BigDecimal.ROUND_HALF_EVEN).doubleValue();
        }
        System.out.println(result);
    }
//    public double divide(int a, int b, int scale){
//        return divide((double)a, (double)b, scale);
//    }
    @Test
    public void divideTest(){
        System.out.println(divide(13232, 523, 4));
        int i = (int)(23.3/4.3);
        System.out.println(i);
    }
    public double divide(int a, int b, int scale){
        BigDecimal dividend = new BigDecimal(a);
        BigDecimal divisor = new BigDecimal(b);
        return dividend.divide(divisor, scale, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }
    @Test
    public void arrayTest(){
        int[] arr = new int[10];
        for(int i : arr){
            System.out.println(i);
        }
        for(int i = 0;i<43;i++){
            arr[i%10]++;
            for(int v:arr){
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
    @Test
    public void statistic(){
        double[] arr = new double[]{1.2342342, 5.256423, 23.62346, 9.131345, 5.64763,14.343424,29.234234,18.34324,20.3424};
        double max = 0;
        for(double d:arr){
            max = d>max?d:max;
        }
        double inter = max/5;
        System.out.println(max+" : "+inter);
        int[] stat = new int[5];
        for(double d : arr){
            int index = (int)(d/inter);
            if(index>=5){index--;}
            stat[index]++;
        }
        String str = "";
        StringBuilder sb = new StringBuilder();
        for(int i:stat){
            str+=i+"*";
        }
        System.out.println(str.substring(0, str.length()));
        System.out.println(str.substring(0, str.length()-1));
        System.out.println(Joiner.on("%").skipNulls().appendTo(sb, ArrayUtils.toObject(stat)));
        Arrays.sort(arr);
        for(double d:arr){
            System.out.print(d + " ");
        }
        System.out.println();
        System.out.println(Math.round(4.23242));
    }
    @Test
    public void timer(){
        long n = 1L<<30;
        long r = 0;
        for(long i = 0;i<n;i++){
            r = Math.round(1.4999999999);
        }
        System.out.println(r);
        System.out.println(n);
        System.out.println(getString(3.4555454));
        System.out.println(getString(3.453434));
    }

    public static String getString(double d){
        double r = Math.round(d*100)/100.0;
        return String.valueOf(r);
    }
    @Test
    public void crc32Test(){
        CRC32 crc32 = new CRC32();
        crc32.update("9311".getBytes());
        System.out.println(crc32.getValue());
        Random random = new Random();
        for(int i = 0;i<10;i++) {
            System.out.print(random.nextInt(3) + "  ");
            System.out.print(random.nextFloat() * 100 + "  ");
            int t = (int)(System.currentTimeMillis()/1000- random.nextInt(90)*3600*24);
            System.out.print(t + "   ");
            System.out.print(new Date((long)t*1000)+"   ");
            float f = (float)random.nextGaussian();
            f = f>0?f:-f;
            System.out.println(f);
        }
        System.out.println(new Date((long)1455524463*1000));
    }
    @Test
    public void getCRC32(){
        int[] pois = new int[]{1233,2384,12309,9311,7294,32423,24592,908,23443,10495};
        for(int i : pois) {
            CRC32 crc32 = new CRC32();
            String str = ""+i;
            crc32.update(str.getBytes());
            System.out.println(i+" : "+crc32.getValue()%100);
        }

    }
}
