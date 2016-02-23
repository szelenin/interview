package other;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/23/2016.
 */
public class RecursionTest {
    @Test
    public void shouldFactorial(){
        assertEquals(120, Recursion.factorial(5, 1));
    }

}