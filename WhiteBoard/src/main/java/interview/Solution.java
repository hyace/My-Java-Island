package interview;

import collection.Node;

/**
 * Created by Chyace on 2015/8/26.
 */
public class Solution {
    /**
     * Reverse a list.
     */
    public static <T> Node<T> reverseList(Node<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node<T> p = null, cur = head, n = head;
        while (n != null) {
            n = n.getNext();
            cur.setNext(p);
            p = cur;
            cur = n;
        }
        return p;
    }

    /**
     * Josephus
     */
    public static int josephus(int n, int step) {
        if (n == 1) {
            return 0;
        }
        int x = josephus(n - 1, step);
        x = (x + step) % n;
        return x;
    }
}
