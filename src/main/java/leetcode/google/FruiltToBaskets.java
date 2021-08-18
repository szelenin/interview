package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class FruiltToBaskets {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> baskets = new HashMap<>();
        int max = 1;
        int basketsStartIdx = 0;
        for (int i = 0; i < fruits.length; i++) {
            baskets.put(fruits[i], i);
            if (baskets.size() > 2) {
                int min = Integer.MAX_VALUE;
                for (Integer val : baskets.values()) {
                    min = Math.min(val, min);
                }
                baskets.remove(fruits[min]);
                basketsStartIdx = min + 1;
            }
            max = Math.max(max, i - basketsStartIdx + 1);
        }
        return max;
    }
}
