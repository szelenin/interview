package leetcode.google;

import java.util.Arrays;

//https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/3089/
public class SplitArraysDP {

    private int maxGroupSum(int[] nums, int[] mIdxs, int[] prevMIdxs, int[] prevGroupSums) {
        //[1,2,3,4,5] m=3
        //prevGroupSums: sum(0..0), sum(1..1), sum(2..4), prevMIdxs = [1,2], mIdx = [1,3]
        //prevGroupSums: sum(0..0), sum(1..2), sum(3..4), prevMIdxs = [1,3], mIdx = [1,4]
        //prevGroupSums: sum(0..0), sum(1..3), sum(4..4), prevMIdxs = [1,4], mIdx = [2,3] !
        //prevGroupSums: sum(0..1), sum(2..2), sum(3..4), prevMIdxs = [2,3], mIdx = [2,4]
        //prevGroupSums: sum(0..1), sum(2..3), sum(4..4), prevMIdxs = [2,4], mIdx = [3,4]
        //prevGroupSums: sum(0..2), sum(3..3), sum(4..4) <- shouldn't be called
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prevMIdxs.length; i++) {
            if (prevMIdxs[i] < mIdxs[i]) {
                prevGroupSums[i] += nums[prevMIdxs[i]];
                prevGroupSums[i + 1]-=nums[prevMIdxs[i]];
            }
            if (prevMIdxs[i] > mIdxs[i]) {
                prevGroupSums[i + 1] += nums[mIdxs[i]];
                prevGroupSums[i] -= nums[mIdxs[i]];
            }
            max = Math.max(max, prevGroupSums[i]);
        }
        return max;
    }

    //calculate groupSums and return max sum
    //groupSums.length = mIdxs.length + 1 (number of groups)
    private int calcGroupSums(int[] nums, int[] mIdxs, int[] groupSums) {
        int max = Integer.MIN_VALUE;
        int groupSum = 0;
        for (int i = 0, splitStart = 0; i < nums.length; i++) {
            if (splitStart < mIdxs.length && i == mIdxs[splitStart]) {
                max = Math.max(max, groupSum);
                groupSums[splitStart] = groupSum;
                splitStart++;
                groupSum = 0;
            }
            groupSum += nums[i];
        }
        groupSums[groupSums.length - 1] = groupSum;
        return Math.max(max, groupSum);
    }

    public int splitArray(int[] nums, int m) {
        //[1,2,3,4,5] m=2
        //sum(0..0),sum(1..4)
        //sum(0..1), sum(2..4)
        //sum(0..2), sum(3..4)
        //sum(0..3), sum(4..4)
        //[1,2,3,4,5] m=3
        //sum(0..0), sum(1..1), sum(2..4) - 1,2
        //sum(0..0), sum(1..2), sum(3..4) - 1,3
        //sum(0..0), sum(1..3), sum(4..4) - 1,4
        //sum(0..1), sum(2..2), sum(3..4) - 2,3
        //sum(0..1), sum(2..3), sum(4..4) - 2,4
        //sum(0..2), sum(3..3), sum(4..4) - 3,4
        int[] mIdx = new int[m - 1];
        for (int i = 0; i < mIdx.length; i++) {
            mIdx[i] = i + 1;
        }
        int[] groupSums = new int[m];
        int min = Math.min(Integer.MAX_VALUE, calcGroupSums(nums, mIdx, groupSums));
        int[] prevMIdx = Arrays.copyOf(mIdx, mIdx.length);
        while (nextIdx(mIdx, nums.length)) {
            min = Math.min(min, maxGroupSum(nums, mIdx, prevMIdx, groupSums));
            prevMIdx = Arrays.copyOf(mIdx, mIdx.length);
        }
        return min;
    }

    private boolean nextIdx(int[] mIdx, int numsLen) {
        //[1,2,3]->[1,2,4] when m=3, numLen = 5
        //when m=2, numLen=5
        //[1,2]->[1,3],[1,4],[2,3],[2,4],[3,4]

        for (int i = 0; i < mIdx.length; i++) {
            int idx = mIdx.length - 1 - i;
            if (mIdx[idx] < numsLen - i - 1) {
                mIdx[idx]++;
                return true;
            }
            if (idx == 0) {
                return false;
            }
            mIdx[idx - 1]++;
            mIdx[idx] = mIdx[idx - 1] + 1;
        }
        return true;
    }

}
