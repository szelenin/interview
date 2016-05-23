package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergii_Zelenin on 5/22/2016.
 * https://www.youtube.com/watch?v=W9gMt8b3mfM
 */
public class FromGuy43 {
    public static List<List<Character>> decipherWays(int[] ciphed) {
        return decipherWays(ciphed, 0);
    }

    private static List<List<Character>> decipherWays(int[] ciphed, int current) {
        ArrayList<List<Character>> ways = new ArrayList<>();
        if (current >= ciphed.length) {
            return ways;
        }
        if (current == ciphed.length - 1) {
            ways.add(Arrays.asList(fromInt(ciphed[current])));
            return ways;
        }
        ways.addAll(decipherWays(ciphed, current + 1));
        addCharToFront(ways, fromInt(ciphed[current]));

        if (current == ciphed.length - 2) {
            int combined = combine(ciphed[current], ciphed[current + 1]);
            if (combined <= 26) {
                ways.add(Arrays.asList(fromInt(combined)));
                return ways;
            }
        }

        if (current < ciphed.length - 2) {
            int combined = combine(ciphed[current], ciphed[current + 1]);
            if (combined <= 26) {
                ways.addAll(decipherWays(ciphed, current + 2));
                addCharToFront(ways, fromInt(combined));
            }
        }
        return ways;
    }

    private static void addCharToFront(ArrayList<List<Character>> ways, char currentChar) {
        for (int i = 0; i < ways.size(); i++) {
            ArrayList<Character> newWay = new ArrayList<>();
            newWay.add(currentChar);
            newWay.addAll(ways.get(i));
            ways.set(i, newWay);
        }
    }

    private static int combine(int first, int second) {
        return Integer.parseInt("" + first + second);
    }

    private static char fromInt(int charPosition) {
        return (char)('a' + charPosition - 1);
    }

    private static List<char[]> convertToChars(List<int[]> ways) {
        return null;
    }
}
