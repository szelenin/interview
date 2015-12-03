package arraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/4/2015.
 */
public class Task1Test {

    @Test
    public void should() {
        assertFalse(Task1.allUnique("aa"));
        assertTrue(Task1.allUnique("ab"));
    }
}