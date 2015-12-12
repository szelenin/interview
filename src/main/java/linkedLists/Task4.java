package linkedLists;

/**
 * Created by szelenin on 12/12/2015.
 */

public class Task4 {
    public static Node partition(Node head, int x) {
        Pair left = new Pair();
        Pair right = new Pair();
        Node current = head;
        while (current != null) {
            Pair active = right;
            if (current.data < x) {
                active = left;
            }
            if (active.head == null) {
                active.head = current;
                active.tail = current;
                current = current.next;
                continue;
            }
            active.tail.next = current;
            active.tail = current;
            current = current.next;
        }

        if (left.head == null) {
            return right.head;
        }
        if (right.head == null) {
            return left.head;
        }
        left.tail.next = right.head;
        right.tail.next = null;
        return left.head;
    }
}