package recursionAndDp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/14/2016.
 */
public class RdpTask2Test {
    @Test
    public void should() {
        assertEquals(2, RdpTask2.countPaths(1, 1));
        assertEquals(3, RdpTask2.countPaths(1, 2));
    }

}