package recursionAndDp;

import java.util.Stack;

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
        Stack stack = new Stack();
        stack.push(new Object[]{total, denom});
        int ways = 0;
        while (!stack.isEmpty()) {
            Object[] pop = (Object[]) stack.pop();
            total = (int) pop[0];
            denom = (int) pop[1];
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
                    ways ++;
                    continue; // Found a combination.Base case.
                default:
                    continue;
            }

            for (int count = 0; count*denom <= total; ++count) {
                stack.push(new Object[]{total - count * denom, nextCoin});
            }
        }
        return ways;
    }
}
