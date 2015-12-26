package stacksAndQueues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/26/2015.
 */
public class Task5MyQueueTest {
    @Test
    public void should(){
        Task5MyQueue queue = new Task5MyQueue();
        queue.put(1);
        queue.put(2);

        assertEquals(1, queue.get());
        assertEquals(2, queue.get());
    }

    @Test
    public void should2(){
        Task5MyQueue queue = new Task5MyQueue();
        queue.put(1);
        queue.get();
        queue.put(2);
        queue.put(3);

        assertEquals(2, queue.get());
        assertEquals(3, queue.get());
    }
}