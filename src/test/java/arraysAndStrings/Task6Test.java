package arraysAndStrings;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/5/2015.
 */
public class Task6Test {
    @Test
    public void should() {
        int[][] image = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] rotated = {{7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}};

        assertTrue(Arrays.equals(rotated, Task6.rotate(image)));
    }
}