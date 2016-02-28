package recursionAndDp;

/**
 * Created by szelenin on 2/27/2016.
 */
public class RdpTask8 {
    public static int numWays(int n) {
        int[] denoms = new int[]{25, 10, 5, 1};
        return numWays(n, 0, denoms);

    }

    private static int numWays(int n, int currentIdx, int[] denoms) {
        if (n < 0 || currentIdx >= denoms.length) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return numWays(n, currentIdx + 1, denoms) + numWays(n - denoms[currentIdx], currentIdx, denoms);
    }

    public static int numWaysBook(int n) {
        return makeChange(n, 25);
    }
    private static int makeChange(int total, int denom) {
        int nextCoin = 0;
        switch (denom) {
            case 25:
                nextCoin = 10;
                break;
            case 10:
                nextCoin = 5;
                break;
            case 5:
                nextCoin = 1;
                break;
            case 1:
                return 1; // Found a combination.Base case.
            default:
                return 0;
        }

        int ways = 0;
        for (int count = 0; count*denom <= total; ++count) {
            ways += makeChange(total-count*denom, nextCoin);
        }
        return ways;
    }
}
