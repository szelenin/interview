package linkedLists;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 3/5/2016.
 */
public class FromGuy50Test {
    @Test
    public void shouldCreateWhenNull(){
        assertEquals("1,null", new ListUtils().toString(FromGuy50.findNodeCircular(null, 1)));
    }

    @Test
    public void shouldCreateWhenOneNode(){
        Node head = new Node(1);
        head.next = head;
        assertEquals("1,2,null", new ListUtils().toString(FromGuy50.findNodeCircular(head, 2)));
    }

    @Test
    public void shouldCreateWhenBigger(){
        Node head = new Node(1);
        Node node = new Node(3);
        head.next = node;
        node.next = head;
        assertEquals("1,2,3,null", new ListUtils().toString(FromGuy50.findNodeCircular(head, 2)));
    }

    @Test
    public void shouldCreateWhenTail(){
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.next = node2;
        node2.next = node3;
        node3.next = head;
        assertEquals("1,2,3,4,null", new ListUtils().toString(FromGuy50.findNodeCircular(head, 4)));
    }

    @Test
    public void shouldCreateWhenSmallest(){
        Node head = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        head.next = node2;
        node2.next = node3;
        node3.next = head;
        assertEquals("1,2,3,4,null", new ListUtils().toString(FromGuy50.findNodeCircular(head, 1)));
    }

}