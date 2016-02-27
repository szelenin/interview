package recursionAndDp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by szelenin on 2/27/2016.
 */
public class RdpTask7Test {
    @Test
    public void shouldFill(){
        int[][] a = new int[][]{
                {0, 0, 1},
                {0, 1, 0},
                {1, 0, 0}
        };
        RdpTask7.fill(a, 2, 0, 0);
        assertEquals("[2, 2, 1];[2, 1, 0];[1, 0, 0];", toString(a));
        RdpTask7.fill(a, 3, 1, 1);
        assertEquals("[2, 2, 3];[2, 3, 0];[3, 0, 0];", toString(a));
    }

    @Test
    public void shouldFill2(){
        int[][] a = new int[][]{
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {1, 0, 0, 0}
        };
        RdpTask7.fill(a, 2, 3, 1);
        assertEquals("[0, 0, 1, 2];[0, 1, 2, 2];[1, 2, 2, 2];", toString(a));
    }



    private String toString(int[][] a) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : a) {
            sb.append(Arrays.toString(row)).append(";");
        }
        return sb.toString();
    }

}