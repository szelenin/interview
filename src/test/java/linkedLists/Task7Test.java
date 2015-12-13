package linkedLists;

import org.junit.Test;

import static linkedLists.Task7.isPalindrome;
import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/13/2015.
 */
public class Task7Test {
    @Test
    public void should(){
        assertTrue(isPalindrome(new Node(1, new Node(2, new Node(2, new Node(1))))));
        assertTrue(isPalindrome(new Node(1)));
        assertFalse(isPalindrome(new Node(1, new Node(2))));
    }
}