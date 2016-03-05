package linkedLists;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 3/5/2016.
 */
public class FromGuy1Test {
    @Test
    public void should(){
        Node head = new Node(1, new Node(2, new Node(3, new Node(4))));
        assertEquals("4,3,2,1,null", new ListUtils().toString(FromGuy1.reverse(head)));
    }

}