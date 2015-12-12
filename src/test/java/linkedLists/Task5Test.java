package linkedLists;

import org.junit.Test;

import static linkedLists.Task5.plus;
import static linkedLists.TestUtils.listToString;
import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/12/2015.
 */
public class Task5Test {
    @Test
    public void should(){
        assertEquals("2 ", listToString(plus(new Node(1), new Node(1))));
        assertEquals("2 2 ", listToString(plus(new Node(1, new Node(2)), new Node(1))));
        assertEquals("8 9 1 ", listToString(plus(new Node(9, new Node(9)), new Node(9, new Node(9)))));
    }

}