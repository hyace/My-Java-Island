package interview;

import org.junit.Test;

/**
 * Created by Chyace on 2015/8/26.
 */
public class Stack2QueueTest {
    @Test
    public void stack2queue() {
        Stack2Queue<Integer> sq = new Stack2Queue<Integer>();
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
            sq.push(i);
        }
        System.out.println();
        System.out.println(sq.pop());
        for (int i = 5; i < 10; i++) {
            System.out.print(i + " ");
            sq.push(i);
        }
        System.out.println();
        while (!sq.isEmpty()) {
            System.out.print(sq.pop() + " ");
        }
    }
}
