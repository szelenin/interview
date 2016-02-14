package recursionAndDp;

/**
 * Created by szelenin on 2/14/2016.
 */
public class RdpTask1 {
    public static int countWays(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }
}
