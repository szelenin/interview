package linkedLists;

/**
 * Created by szelenin on 3/5/2016.
 */
public class FromGuy50 {
    public static Node findNodeCircular(Node head, int value) {
        Node node = new Node(value);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (value < head.data) {
            node.next = head;
            return node;
        }
        Node current = head;
        while (current.next != null && value > current.next.data) {
            if (current.next == head) {
                break;
            }
            current = current.next;
        }
        Node tmp = current.next;
        current.next = node;
        node.next = tmp;
        return head;
    }

}
