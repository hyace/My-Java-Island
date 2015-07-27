package notes;

import org.junit.Test;

/**
 * Created by Chyace on 2015/7/20.
 */
public class Chapter2 {
    /**
     * P21 可重入锁，同一对象持有同一锁，再调用同一对象的其他同步方法时不需要再次请求锁，
     * 这是java thread特有的，而Unix 的pthread是以请求为粒度的。
     */
    @Test
    public void testWidget(){
        LoggingWidget l = new LoggingWidget();
        l.printResult();
    }
    class Widget{
        public synchronized void printResult(){
            System.out.println("Parent class!");
        }
    }
    class LoggingWidget extends Widget{
        @Override
        public synchronized void printResult() {
            System.out.println("Child class!");
            super.printResult();
        }
    }
}
