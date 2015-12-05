package arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by szelenin on 12/5/2015.
 */
public class Task2 {
    public static boolean isPermutation(String s1, String s2){
        if (s1 == null || s2 ==null) {
            return false;
        }
        if (s1.length() != s2.length()){
            return false;
        }
        CharCounts counts1 = new CharCounts(s1);
        CharCounts counts2 = new CharCounts(s2);
        return counts1.equals(counts2);
    }

    public static class CharCounts {
        private Map<Character, Integer> counts = new HashMap<>();
        public CharCounts(String s) {
            for (int i = 0; i < s.length(); i++) {
                Character currentChar = s.charAt(i);
                Integer count = counts.get(currentChar);
                if (count == null) {
                    count = 0;
                }
                counts.put(currentChar, ++count);
            }
        }

        public boolean equals(Object o){
            if (o == null){
                return false;
            }
            if (o instanceof CharCounts) {
                return ((CharCounts) o).counts.equals(this.counts);
            }
            return false;
        }
    }
}
