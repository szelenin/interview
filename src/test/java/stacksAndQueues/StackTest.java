package stacksAndQueues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/13/2015.
 */
public class StackTest {
    @Test
    public void should(){
        Stack stack = new Stack();

        assertTrue(stack.isEmpty());

        stack.push(1);

        assertFalse(stack.isEmpty());

        assertEquals(1, stack.peek());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void should2(){
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        try {
            stack.peek();
            fail();
        } catch (Exception e) {

        }
    }
}