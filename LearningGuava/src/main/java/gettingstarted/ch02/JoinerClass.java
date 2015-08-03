package gettingstarted.ch02;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import junit.framework.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chyace on 15-7-18.
 */
public class JoinerClass {
    /**
     * Joiner类
     * * on方法可以指定分隔符
     * * skipNulls可以跳过null值
     * * join方法指定处理的Object[]
     * * useForNull 方法指定替换null值的字符串
     * * appendTo 第一个参数为StringBuilder，之后为需要append的String，返回StringBuilder
     *            第一个参数也可以为所有实现了Appendable接口的类，比如FileWriter，后面参数追加到目标末尾
     * * withKeyValueSeparator 方法，能够指定Map的键值之间的连接符，从而join Map的内容。
     *            该方法被调用的时候，会生成内部类MapJoiner，之后调用的join方法是MapJoiner自己实现的方法。
     *            这种方法比较巧妙，在方法调用的同时，指定实现方法。
     *
     * 注意： 其中的null不包含""的情况。如果存在null，直接join而不使用useForNull或者skipNulls的话会抛出
     * “java.lang.NullPointerException”
     * 在skipForNulls后调用useForNull是无意义的，会抛出
     * “java.lang.UnsupportedOperationException: already specified skipNulls”
     * 具体的方法是在各自方法中，返回匿名内部类时覆盖其他冲突的方法，直接抛出异常。
     */
    @Test
    public void joinerTest() throws IOException {
        String[] stringList = {"C",null,"C++","Java","Python","Go",null,"Scala",null,null,"Haskell"};
        String join1 = Joiner.on("~").skipNulls().join(stringList);
//        System.out.println(JoinerClass.on("-").join(stringList));
        System.out.println("Skip Nulls : "+join1);
        String join2 = Joiner.on("^").useForNull("Blank").join(stringList);
        System.out.println("Use For Null : "+ join2);

//        String join3 = JoinerClass.on("*").skipNulls().useForNull("NIL").join(stringList);
//        System.out.println(join3);
        /**  StringBuilder */
        System.out.println("——For StringBuilder——");
        StringBuilder sb = new StringBuilder();
        sb.append("RedHat").append("Windows").append("Solaris").append("AIX").append("OSX");
        System.out.println(sb);
        System.out.println(Joiner.on('#').skipNulls().appendTo(sb,"DOS",null,"Ubuntu"));
        /** Appendable */
        FileWriter fw = new FileWriter(new File("file/joiner"));
        Joiner.on("|").useForNull(" NIL ").appendTo(fw, stringList);
        fw.flush();
        fw.close();

        /** MapJoiner **/
        // Maps是guava中的集合类，可以用静态工厂得到Map
        Map<Integer,String> map = Maps.newLinkedHashMap();
        String expectedString = "1:One+++2:Two+++3:Three";
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3, "Three");
        String join3 = Joiner.on("+++").withKeyValueSeparator(":").join(map);
        // 原文这里用的是Hamcrest的assertThat
        Assert.assertEquals(expectedString,join3);
    }
}
