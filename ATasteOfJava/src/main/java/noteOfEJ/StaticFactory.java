package noteOfEJ;

import enumeration.Num;
import enumeration.Planet;
import org.junit.Test;

import java.math.BigInteger;
import java.util.EnumSet;
import java.util.Random;

/**
 * Created by Chyace on 2015/8/17.
 */
public class StaticFactory {
    /**
     * 静态工厂
     * * 相对于构造器，特有的名称能够区分不同的功能。
     * * 不用每次都构建新的实例，可以重复利用。
     * * 静态工厂可以返回原类型的任意子类对象。
     */
    @Test
    public void staticFactory(){
//        BigInteger a = BigInteger.probablePrime(5,new Random(9000));
//        System.out.println(a);
        //EnumSet，枚举类型<=64个，静态方法返回RegalarEnumSet，long支持；>64，返回jumboEnumSet,long数组支持
        EnumSet<Num> numSet = EnumSet.range(Num.四, Num.三十四);
        System.out.println(numSet.getClass());
        EnumSet<Planet> numSetII = EnumSet.allOf(Planet.class);
        System.out.println(numSetII.getClass());
    }
}
