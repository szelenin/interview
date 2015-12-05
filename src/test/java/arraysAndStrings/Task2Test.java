package arraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/5/2015.
 */
public class Task2Test {
    @Test
    public void should() {
        assertTrue(Task2.isPermutation("ab", "ba"));
        assertFalse(Task2.isPermutation("aa", "ab"));
    }
}