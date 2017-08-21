package other;

/**
 * Created by Sergii_Zelenin on 8/21/2017.
 */
public class Change {
    public static int change(int amount, int[] coins) {
        //min(min(amount - coins[0])+1, min(amount - coins[1]) + 1 ...)
        if (amount <= 0) {
            return 0;
        }
        int minChange = Integer.MAX_VALUE;
        for (int coin : coins) {
            minChange = Math.min(change(amount - coin, coins) + 1, minChange);
        }
        return minChange;
    }
}
