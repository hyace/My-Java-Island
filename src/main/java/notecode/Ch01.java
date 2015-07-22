package notecode;

import com.google.common.base.Joiner;
import org.junit.Test;

/**
 * Created by chyace on 15-7-18.
 */
public class Ch01 {
    /**
     * Joiner类
     * on方法可以指定分隔符
     * skipNulls可以跳过null值
     * join方法指定处理的Object[]
     * useForNull 方法指定替换null值的字符串
     *
     * 注意： 其中的null不包含""的情况。如果存在null，直接join的话会抛出 java.lang.NullPointerException
     *
     */
    @Test
    public void joinerTest(){
        String[] stringList = {"C",null,"C++","Java","Python","Go",null,"Scala",null,null,"Haskell"};
        String join1 = Joiner.on("~").skipNulls().join(stringList);
        System.out.println(Joiner.on("-").join(stringList));
        System.out.println("Skip Nulls : "+join1);
        String join2 = Joiner.on("^").useForNull("Blank").join(stringList);
        System.out.println("Use For Null : "+ join2);
    }
}
