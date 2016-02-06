package bitManipulation;

/**
 * Created by szelenin on 2/6/2016.
 */
public class BmTask3 {
    private static int minMask(int v) {
        int result = 0;
        int mask = 1;
        while (v > 0) {
            result += v & mask;
            v >>= 1;
        }
        return ((int) Math.pow(2, result)) - 1;
    }

    public static int nextMin(int v) {
        return minMask(v);
    }

    public static int nextMax(int v) {
        int minMask = minMask(v);
        int onesCnt = (int) (Math.log(minMask + 1) / Math.log(2));
        return minMask << (32 - onesCnt);
    }
}
