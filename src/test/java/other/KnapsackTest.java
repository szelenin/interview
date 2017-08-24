package other;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 8/23/2017.
 */
public class KnapsackTest {
    @Test
    public void test() {
        assertEquals(48, Knapsack.optimal(10, new int[]{6, 3, 4, 2}, new int[]{30, 14, 16, 9}));
    }

    @Test
    public void testWoRepetition() {
        assertEquals(46, Knapsack.optimalWoRepetition(10, new int[]{6, 3, 4, 2}, new int[]{30, 14, 16, 9}));
    }

}