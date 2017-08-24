package other;

import java.util.Arrays;

/**
 * Created by Sergii_Zelenin on 8/23/2017.
 */
public class Knapsack {

    public static int optimal(int bag, int[] w, int v[]) {
        int d[] = new int[bag + 1];
        for (int i = 1; i <= bag; i++) {
            for (int j = 0; j < v.length; j++) {
                if (i >= w[j]) {
                    int maxValueWithItem = d[i - w[j]] + v[j];
                    if (maxValueWithItem > d[i]) {
                        d[i] = maxValueWithItem;
                    }
                }
            }
        }
        return d[bag];
    }

    public static int optimalWoRepetition(int bag, int w[], int v[]) {
        int[][] d = new int[w.length + 1][bag + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= bag; j++) {
                //do we take Ith element to the bag of size J?
                //if take: v = d[i - 1][j - w[i - 1]] + v[i - 1]
                //not take: v = d[i - 1][j - 1]
                d[i][j] = d[i - 1][j];
                if (w[i - 1] <= j) {
                    d[i][j] = Math.max(d[i][j], d[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return d[w.length][bag];
    }
/*
    public static int optimal(int bag, int[] v, int w[]) {
        //d[0..bag][0..v.length]
        //d[i,j] = max(take jth, not take jth)
        // take jth = d[i - v[j]][j] + w[j]
        // not take jth = d[i - 1][j]
        //return max(d[bag][...])
        int[][] d = new int[bag + 1][v.length];
        for (int i = 1; i <= bag; i++) {
            for (int j = 0; j<v.length;j++) {
                int takeJ = 0;
                if (i - v[j] >= 0){
                    takeJ = d[i - v[j]][j] + w[j];
                }
                int notTakeJ = d[i - 1][j];
                d[i][j] = Math.max(takeJ, notTakeJ);
            }
        }
        return Arrays.stream(d[bag]).max().orElse(-1);
    }
*/
}
