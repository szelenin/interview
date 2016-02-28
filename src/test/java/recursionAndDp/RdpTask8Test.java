package recursionAndDp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/27/2016.
 */
public class RdpTask8Test {
    @Test
    public void shouldNumWays(){
        assertEquals(2, RdpTask8.numWaysBook(6));
        assertEquals(242, RdpTask8.numWays(100));
        assertEquals(242, RdpTask8.numWaysBook(100));
        long start = System.currentTimeMillis();
        System.out.println("RdpTask8.numWays(100) = " + RdpTask8.numWays(26));
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.println("RdpTask8.numWays(100) = " + RdpTask8.numWaysBook(26));
        System.out.println(System.currentTimeMillis() - start);
    }

}