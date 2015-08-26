package interview;

import collection.Node;
import org.junit.Before;
import org.junit.Test;
import util.CollectionTools;

/**
 * Created by Chyace on 2015/8/26.
 */
public class ReverseTest {
    Node<String> head = new Node<String>("0");

    @Before
    public void prepareLinkedList() {
        Node<String> p = head;
        for (int i = 1; i < 10; i++) {
            p.setNext(new Node<String>(String.valueOf(i)));
            p = p.getNext();
        }
    }

    @Test
    public void reverseTest() {
        CollectionTools.print(head);
        System.out.println();
        CollectionTools.print(Solution.reverseList(head));
    }
}
