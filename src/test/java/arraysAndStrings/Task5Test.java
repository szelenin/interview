package arraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/5/2015.
 */
public class Task5Test {
    @Test
    public void should() {
        assertEquals("aa", Task5.compress("aa"));
        assertEquals("a2b1c5a3", Task5.compress("aabcccccaaa"));
        assertEquals("a2b5c1a1", Task5.compress("aabbbbbca"));
    }
}