package stacksAndQueues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/13/2015.
 */
public class MinStackTest {
    @Test
    public void should(){
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(7);

        assertEquals(3, stack.min());
        stack.pop();
        stack.pop();
        assertEquals(5, stack.min());
        stack.pop();
        assertEquals(5, stack.min());
    }

}