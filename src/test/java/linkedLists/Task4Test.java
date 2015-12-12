package linkedLists;

import org.junit.Test;

import static linkedLists.Task4.partition;
import static linkedLists.TestUtils.listToString;
import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/12/2015.
 */
public class Task4Test {
    @Test
    public void should() {
        Node head = new Node(3, new Node(1, new Node(4, new Node(2))));
        assertEquals("1 2 3 4", listToString(partition(head, 3)));
    }
}