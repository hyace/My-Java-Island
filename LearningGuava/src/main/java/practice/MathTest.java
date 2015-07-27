package practice;

import com.google.common.math.LongMath;
import org.junit.Test;

/**
 * Created by Administrator on 2015/7/21.
 */
public class MathTest {
    /**
     * guava的阶乘是直接定义常量数组，到20封顶，21以上都是Long.MAX_VALUE了。
     */
    @Test
    public void testFactorial() {
        System.out.println(LongMath.factorial(19));
        System.out.println(LongMath.factorial(20));
        System.out.println(LongMath.factorial(21));
        System.out.println(LongMath.factorial(22));
        System.out.println(LongMath.factorial(23));
        System.out.println(LongMath.factorial(24));
    }
}
