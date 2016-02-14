package recursionAndDp;

import org.junit.Test;

import java.util.List;

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

    @Test
    public void shouldGetpath() {
        boolean[][] spots = new boolean[][]{
                {false, false, true},
                {false, true, false},
                {false, false, false}
        };

        List<RdpTask2.Point> path = RdpTask2.path(2, 1, spots);
        System.out.println("path = " + path);
    }
}