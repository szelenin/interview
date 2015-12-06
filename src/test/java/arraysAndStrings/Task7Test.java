package arraysAndStrings;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 12/6/2015.
 */
public class Task7Test {
    @Test
    public void should() {
        int[][] matrix = new int[][]{{1, 2}, {3, 0}};
        int[][] expected = new int[][]{{1, 0}, {0, 0}};

        assertEquals(toString(expected), toString(Task7.replaceZeros(matrix)));
    }

    @Test
    public void should2() {
        int[][] matrix = new int[][]{
                {1, 2,  3,  4},
                {5, 6,  7,  8},
                {9, 10, 11, 0},
        };
        int[][] expected = new int[][]{
                {1, 2,  3,  0},
                {5, 6,  7,  0},
                {0, 0,  0,  0},
        };

        assertEquals(toString(expected), toString(Task7.replaceZeros(matrix)));
    }

    @Test
    public void should3() {
        int[][] matrix = new int[][]{
                {1, 2,  3,  4},
                {5, 6,  7,  8},
                {9, 0, 11, 0},
        };
        int[][] expected = new int[][]{
                {1, 0,  3,  0},
                {5, 0,  7,  0},
                {0, 0,  0,  0},
        };

        assertEquals(toString(expected), toString(Task7.replaceZeros(matrix)));
    }

    private String toString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append(Arrays.toString(matrix[i])).append("\n");
        }
        return sb.toString();
    }

}