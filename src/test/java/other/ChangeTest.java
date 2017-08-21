package other;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 8/21/2017.
 */
public class ChangeTest {
    @Test(timeout = 1000)
    public void testTimeout(){
        assertEquals(20, Change.change(400, new int[]{20, 10, 5, 1}));
    }

    @Test
    public void test(){
        assertEquals(2, Change.change(40, new int[]{20, 10, 5, 1}));
    }

    @Test(timeout = 1000)
    public void testTimeoutDp(){
        assertEquals(20, Change.changeDp(400, new int[]{20, 10, 5, 1}));
    }

    @Test
    public void testDp(){
        assertEquals(2, Change.changeDp(40, new int[]{20, 10, 5, 1}));
    }

}