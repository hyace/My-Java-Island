package practice;

import org.junit.Test;

/**
 * Created by Hyace on 2015/9/1.
 */
public class InnerTest {
    @Test
    public void innerTest() {
        //静态内部类，应该是外部类什么时候调，什么时候初始化
        StaticInnerClass sc = new StaticInnerClass();
        StaticInnerClass.Inner.printStatic();

    }
}
