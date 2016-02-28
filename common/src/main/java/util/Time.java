package util;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Author: 张晖
 * MIS: zhanghui20
 * Date: 16/2/18
 * Email: zhanghui20@meituan.com
 */
public class Time {
    static int h = 1000*3600;
    static int d = h*24;
    public static int daysBetween(Date smdate,Date bdate)
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        try {
            smdate=sdf.parse(sdf.format(smdate));
//            bdate=sdf.parse(sdf.format(bdate));
        } catch (ParseException e) {
            return -1;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }
    public int myGapUtil(long fdate, long tdate){
        return (int)((tdate+8*1000*3600)/(1000*3600*24) - (fdate+8*1000*3600)/(1000*3600*24));
    }
    @Test
    public void dayGap(){
        long cur = System.currentTimeMillis();
        long then = 1455612655000L;
        System.out.println(new Date(200000000));
        Date today = new Date(cur);
        Date that = new Date(then);
        System.out.println(that.getTime());
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(that));
        System.out.println(System.currentTimeMillis());
        System.out.println(daysBetween(that, today));
        System.out.println(myGapUtil(then, cur));
        System.out.println(200000000/d+" : "+then/d+" : "+cur/d);
        System.out.println(new Date((long)16846*d));
        System.out.println(new Date((long)1*d));
        System.out.println(new Date((long)0));
        System.out.println(today);
        for(int i = 0;i<100000000;i++){
//            daysBetween(that, today);
            myGapUtil(then, cur);
        }
    }
}
