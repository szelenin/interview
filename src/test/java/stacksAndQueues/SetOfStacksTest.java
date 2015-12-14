package stacksAndQueues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/14/2015.
 */
public class SetOfStacksTest {
    @Test
    public void should(){
        SetOfStacks setOfStacks = new SetOfStacks(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);

        assertEquals(3, setOfStacks.pop());
        assertEquals(2, setOfStacks.pop());
        assertEquals(1, setOfStacks.pop());

        try {
            setOfStacks.pop();
            fail();
        } catch (IllegalStateException e) {

        }
    }

}