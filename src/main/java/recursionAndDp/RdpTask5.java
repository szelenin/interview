package recursionAndDp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by szelenin on 2/20/2016.
 */
public class RdpTask5 {
    public static List<String> allPermutations(String str) {
        if (str.length() == 1) {
            return Collections.singletonList(str);
        }

        char lastChar = str.charAt(str.length() - 1);
        List<String> allPermPrev = allPermutations(str.substring(0, str.length() - 1));
        List<String> result = new ArrayList<>();
        for (String prevPerm : allPermPrev) {
            result.addAll(insertChar(prevPerm, lastChar));
        }
        return result;
    }

    private static List<String> insertChar(String perm, char aChar) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < perm.length() + 1; i++) {
            String first = perm.substring(0, i);
            String last = perm.substring(i, perm.length());
            result.add(first + aChar + last);
        }
        return result;
    }
}
