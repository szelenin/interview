package leetcode.google;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FruiltToBasketsTest {
    @Test
    public void test1(){
        FruiltToBaskets fruiltToBaskets = new FruiltToBaskets();
        assertEquals(5, fruiltToBaskets.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));

    }
}