package practice.logging;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.logging.Logger;

/**
 * Created by hyace on 16/1/18.
 */
public class LogTest {
    @Test
    public void msgTest(){
        Logger logger = Logger.getLogger(LogTest.class.getName());
        try {
//            int i = 1/0;
            System.out.println((float)4/3);
            System.out.println((float)(4/3));
            System.out.println(Float.valueOf(4 + "")/3);
            System.out.println(Float.parseFloat(4 + "")/3);
            System.out.println((float)4/3 == Float.parseFloat(4 + "")/3);

//            System.out.println(Float.valueOf(null+"")/3);
            double d = 5 * 0.0;
            System.out.println(Double.doubleToRawLongBits(d));
            System.out.println((double)5/4);
            System.out.println((double)1316294.92);
            System.out.println(new DecimalFormat("#.##").format(12.34567));
            double d1 = 12.34567;
            System.out.println(Double.toString(d1));
        }catch (Exception e){
            logger.info("msg");
        }
    }
}
