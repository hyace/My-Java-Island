package util;

import collection.Node;

/**
 * Created by Chyace on 2015/8/12.
 */
public class CollectionTools {
    /**
     * This method is using to find the length of list starting from Node "start"
     *
     * @param <T>
     * @return
     */
    public static <T> long len(Node<T> start) {
        long count = 0;
        for (Node<T> p = start; p != null; p = p.getNext()) {
            count++;
        }
        return count;
    }

    public static <T> void print(Node<T> start) {
        for (Node<T> p = start; p != null; p = p.getNext()) {
            System.out.print("[" + p.getValue() + "]");
        }
        System.out.println();
    }
}
