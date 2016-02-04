package bitManipulation;

/**
 * Created by szelenin on 2/4/2016.
 */
public class BmTask1 {
    public static int insertBits(int n, int m, int i, int j) {
        int mask = (1 << i - 1) | ~(1 << (j + 1) - 1);
        return n & mask | m << i;
    }
}
