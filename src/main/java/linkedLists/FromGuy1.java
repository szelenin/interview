package linkedLists;

/**
 * Created by szelenin on 3/5/2016.
 */
public class FromGuy1 {
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node tail = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }
}
