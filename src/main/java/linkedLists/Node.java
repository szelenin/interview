package linkedLists;

/**
 * Created by szelenin on 12/12/2015.
 */
public class Node {
    public Node next;
    public int data;

    public Node(int data) {
        this(data, null);
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
