package tree;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by Chyace on 2015/8/12.
 */
public class BSTree<T extends Comparable<T>> {
    Node root;
    Node cur;

    private class Node {
        T value;
        Node left;
        Node right;
    }

    public BSTree() {
        root = new Node();
        cur = root;
    }

    public boolean insert(T value) throws Exception {
        Node tag = null;
        if (root.value == null) {
            root.value = value;
        } else {
            tag = locate(value, root);
        }
        if (tag != null) {
            throw new Exception("Value Exists!");
        }

        //TODO
        return false;
    }

    public Node seek(T value) {
        return locate(value, root);
    }

    private Node locate(T value, Node start) {
        cur = start;
        Node parent;
        while (cur != null) {
            parent = cur;
            if (cur.value.compareTo(value) == 0) {
                return cur;
            }
            if (cur == null) {
                return null;
            }
            if (cur.value.compareTo(value) < 0) {
                return locate(value, cur.left);
            } else {
                return locate(value, cur.right);
            }

        }
        //TODO
        return null;
    }
}
