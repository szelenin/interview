package stacksAndQueues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 1/4/2016.
 */
public class Task6Test {
    @Test
    public void should() {
        java.util.Stack stack = new java.util.Stack();
        stack.push(2);
        stack.push(1);

        Task6.sort(stack);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void should2() {
        java.util.Stack stack = new java.util.Stack();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        Task6.sort(stack);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void should3() {
        java.util.Stack stack = new java.util.Stack();
        stack.push(3);
        stack.push(1);
        stack.push(2);

        Task6.sort(stack);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }
}