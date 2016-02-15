package recursionAndDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by szelenin on 2/15/2016.
 */
public class RdpTask4 {
    public static List<int[]> allSubsets(int maxIdx) {
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < maxIdx; i++) {
            int[] idx = new int[i];
            idx = fillIdx(idx, 1);
            result.addAll(buildIdxComb(idx, maxIdx));
        }
        return result;
    }

    private static List<int[]> buildIdxComb(int[] idx, int maxIdx) {
        List<int[]> list = new ArrayList<>();
        int currentIdx = idx.length - 1;
        while (currentIdx >= 0) {
            list.add(Arrays.copyOf(idx, idx.length));
            idx[currentIdx]++;
            if (idx[currentIdx] > maxIdx) {
                currentIdx--;
                idx = fillIdx(idx, currentIdx);
            }
        }
        return list;
    }

    private static int[] fillIdx(int[] idx, int nextIdx) {
        if (nextIdx < 0) {
            return null;// should never be used
        }
        if (nextIdx >= idx.length) {
            return idx; //when length == 1
        }
        idx[nextIdx]++;
        for (int i = 1; i < idx.length; i++) {
            idx[i] = idx[i - 1] + 1;
        }
        return idx;
    }
}
