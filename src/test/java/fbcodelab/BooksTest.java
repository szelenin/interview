package fbcodelab;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 1/5/2017.
 */
public class BooksTest {
    @Test
    public void test(){
        assertEquals(113, new Books().books(Arrays.asList(12, 34, 67, 90), 2));
        assertEquals(97, new Books().books(Arrays.asList(91,20,62,33,97,31,88,89,73,77,4,58,0,54,60,15,47,80,30,55,46,7,38,0,26,35,57,13), 24));
    }

    @Test
    public void test2(){
        assertEquals(113, new Books().books(Arrays.asList(12, 34, 67, 90, 93), 3));
    }
}