package interview;

import java.util.Stack;

/**
 * Created by Chyace on 2015/8/26.
 * Use two stack to simulate a queue.
 */

public class Stack2Queue<T> {
    private Stack<T> sBase;
    private Stack<T> sTemp;
    private boolean tempIsEmpty;

    public Stack2Queue() {
        sBase = new Stack<T>();
        sTemp = new Stack<T>();
    }

    public boolean isEmpty() {
        return sBase.isEmpty() && sTemp.isEmpty();
    }

    public void push(T item) {
        sBase.push(item);
    }

    public T pop() {
        if (sTemp.isEmpty()) {
            transStack();
        }
        return sTemp.pop();
    }

    private void transStack() {
        while (!sBase.isEmpty()) {
            sTemp.push(sBase.pop());
        }
    }
}
