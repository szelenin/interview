package arraysAndStrings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by szelenin on 12/6/2015.
 */
public class Task7 {
    public static int[][] replaceZeros(int[][]matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Set<Integer> rowsToExclude = new HashSet<>();
        Set<Integer> colsToExclude = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            if (rowsToExclude.contains(i)) {
                continue;
            }
            for (int j = 0; j < m; j++) {
                if (colsToExclude.contains(j)) {
                    continue;
                }
                if (matrix[i][j] == 0) {
                    rowsToExclude.add(i);
                    colsToExclude.add(j);
                }
            }
        }
        for (int i:rowsToExclude) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j:colsToExclude) {
            for (int i = 0; i < n; i++) {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }

}
