package practice;

import collection.Node;
import org.junit.Before;
import org.junit.Test;
import util.CollectionTools;

import java.util.TreeSet;

/**
 * Created by Chyace on 2015/8/12.
 * Find the first shared node of two linked list
 */
public class FindNode {
    Node<String> t1;
    Node<String> t2;

    @Before
    public void prepareList() {
        Node<String> p = new Node<String>("0");
        t1 = p;
        for (int i = 1; i < 100000; i++) {
            Node<String> next = new Node<String>(String.valueOf(i * 2));
            p.setNext(next);
            p = next;
        }
        Node<String> q = new Node<String>("1");
        t2 = q;
        for (int i = 1; i < 1000000; i++) {
            Node<String> next = new Node<String>(String.valueOf(i * 2 + 1));
            q.setNext(next);
            q = next;
        }
        Node<String> sh = new Node<String>("s0");
        p.setNext(sh);
        q.setNext(sh);
        for (int i = 1; i < 1000000; i++) {
            Node<String> next = new Node<String>("s" + String.valueOf(i));
            sh.setNext(next);
            sh = next;
        }
//        System.out.println("List 1 : ");
//        CollectionTools.print(t1);
//        System.out.println("List 2 : ");
//        CollectionTools.print(t2);
        System.out.println("t1: " + CollectionTools.len(t1) + ", t2: " + CollectionTools.len(t2));
    }

    @Test
    public void findNodeTest() {
        Node<String> share = findNode1();
        System.out.println(share);
    }

    private Node<String> findNode1() {
        Node<String> p = t1;
        Node<String> q = t2;
        while (p != null && q != null) {
            p = p.getNext();
            q = q.getNext();
        }
        Node<String> l, s, t;
        if (p == null) {
            l = t2;
            s = q;
            t = t1;
        } else {
            l = t1;
            s = p;
            t = t2;
        }
        while (s != null) {
            l = l.getNext();
            s = s.getNext();
        }
        while (!l.equals(t)) {
            l = l.getNext();
            t = t.getNext();
        }
        return l;
    }
}
