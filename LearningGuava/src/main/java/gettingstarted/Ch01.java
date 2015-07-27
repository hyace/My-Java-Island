package gettingstarted;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chyace on 15-7-18.
 */
public class Ch01 {
    /**
     * Joiner类
     * * on方法可以指定分隔符
     * * skipNulls可以跳过null值
     * * join方法指定处理的Object[]
     * * useForNull 方法指定替换null值的字符串
     * * appendTo 第一个参数为StringBuilder，之后为需要append的String，返回StringBuilder
     *
     * 注意： 其中的null不包含""的情况。如果存在null，直接join而不使用useForNull或者skipNulls的话会抛出
     * “java.lang.NullPointerException”
     * 在skipForNulls后调用useForNull是无意义的，会抛出
     * “java.lang.UnsupportedOperationException: already specified skipNulls”
     * 具体的方法是在各自方法中，返回匿名内部类时覆盖其他冲突的方法，直接抛出异常。
     */
    @Test
    public void joinerTest(){
        String[] stringList = {"C",null,"C++","Java","Python","Go",null,"Scala",null,null,"Haskell"};
        String join1 = Joiner.on("~").skipNulls().join(stringList);
//        System.out.println(Joiner.on("-").join(stringList));
        System.out.println("Skip Nulls : "+join1);
        String join2 = Joiner.on("^").useForNull("Blank").join(stringList);
        System.out.println("Use For Null : "+ join2);

//        String join3 = Joiner.on("*").skipNulls().useForNull("NIL").join(stringList);
//        System.out.println(join3);
        /**  StringBuilder */
        System.out.println("——For StringBuilder——");
        StringBuilder sb = new StringBuilder();
        sb.append("RedHat").append("Windows").append("Solaris").append("AIX").append("OSX");
        System.out.println(sb);
        System.out.println(Joiner.on('#').skipNulls().appendTo(sb,"DOS",null,"Ubuntu"));
        /** Appendable */
        //TODO
    }
}
