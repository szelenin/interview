package other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergii_Zelenin on 8/21/2017.
 */
public class Change {
    private static Map<Integer, Integer> cache = new HashMap<>();

    public static int change(int amount, int[] coins) {
        //min(min(amount - coins[0])+1, min(amount - coins[1]) + 1 ...)
        if (amount <= 0) {
            return 0;
        }
        if (cache.containsKey(amount)) {
            return cache.get(amount);
        }
        int minChange = Integer.MAX_VALUE;
        for (int coin : coins) {
            minChange = Math.min(change(amount - coin, coins) + 1, minChange);
        }
        cache.put(amount, minChange);
        return minChange;
    }

    public static int changeDp(int amount, int[] coins) {
        int[] change = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int minChange = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                minChange = Math.min(change[i - coin] + 1, minChange);
            }
            change[i] = minChange;
        }
        return change[amount];
    }
}
