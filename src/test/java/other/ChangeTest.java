package other;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 8/21/2017.
 */
public class ChangeTest {
    @Test
    public void test(){
        assertEquals(2, Change.change(40, new int[]{20, 10, 5, 1}));
    }

}