package collection;

/**
 * Created by Chyace on 2015/8/12.
 */
public class Node<T> {
    private T value;
    private Node<T> next;

    public Node() {

    }

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "<" + value +" this:"+this.hashCode()+" next: "+ (next == null ? "null" : next.hashCode()) + ">";
    }
}
