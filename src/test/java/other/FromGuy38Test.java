package other;

import linkedLists.Node;
import linkedLists.TestUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 6/13/2016.
 */
public class FromGuy38Test {
    @Test
    public void test(){
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        Node interweaved = FromGuy38.interweave(head);
        assertEquals("1 5 2 4 3 ", TestUtils.listToString(interweaved));
    }

    @Test
    public void test1(){
        Node head = new Node(1, new Node(2, new Node(3, new Node(4))));
        Node interweaved = FromGuy38.interweave(head);
        assertEquals("1 4 2 3 ", TestUtils.listToString(interweaved));
    }

}