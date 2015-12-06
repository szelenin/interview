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

        assertEquals(toString(rotated), toString(Task6.rotate(image)));
    }

    @Test
    public void should3() {
        int[][] image = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16},
        };
        int[][] rotated = {
                {13, 9,  5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4},
        };

        assertEquals(toString(rotated), toString(Task6.rotate(image)));
    }

    @Test
    public void should2() {
        int[][] image = {{1, 2},
                {3,4}};
        int[][] rotated = {{3,1},
                {4, 2}};

        assertEquals(toString(rotated), toString(Task6.rotate(image)));
    }

    private String toString(int[][] img) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < img.length; i++) {
            sb.append(Arrays.toString(img[i])).append("\n");
        }
        return sb.toString();
    }
}