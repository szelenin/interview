package linkedLists;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 3/5/2016.
 */
public class FromGuy1Test {
    @Test
    public void should(){
        Node head = new Node(1, new Node(2, new Node(3, new Node(4))));
        assertEquals("4,3,2,1,null", new ListUtils().toString(myreverseRecur(head)));
    }

    //1,2,3,4 - 4,3,2,1
    //
    private Node myreverse(Node head) {
        Stack<Node> stack = new Stack<>();
        Node current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        head = stack.pop();
        current = head;
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        current.next = null;
        return head;
    }

    //1,2,3,4
    //stack: 4,3,2,1
    //4 - tail, 3 - head, 3->4, 1,2,3,4 : 4->3, 1,2,3 4->3
    //4- tail, 2 - head, 2->3, 123 : 3->2, 12 4->3->2
    private Node myreverseRecur(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node tail = myreverseRecur(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

}