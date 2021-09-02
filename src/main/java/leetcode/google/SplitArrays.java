package leetcode.google;
//https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/3089/
public class SplitArrays {
    private int maxGroupSum(int[] nums, int[] mIdxs) {
        //nums = [1,2,3,4,5], m = 3
        //mIdx.length == m - 1: split indexes, [1,2,3], [1,2,4], [1,3,4], [2,3,4]
        //nums = [1,2,3,4,5], m = 2
        //mIdx.length == m - 1: split indexes, [1,2], [1,3], [1,4]; [2,3], [2,4], [3,4]; [3, 4]
        int max = Integer.MIN_VALUE;
        int groupSum = 0;
        for (int i=0,splitStart=0; i < nums.length; i++){
            if (splitStart < mIdxs.length && i == mIdxs[splitStart]) {
                max = Math.max(max, groupSum);
                splitStart++;
                groupSum=0;
            }
            groupSum+=nums[i];
        }
        return Math.max(max, groupSum);
    }

    public int splitArray(int[] nums, int m) {
        //1st: 0 - nums.lenght - m - 1
        //2nd: 1 - nums.length - m - 1 + 1
        //3nd: 2 - nums.length - m - 1 + 2
        //...
        //mth: m - nums.length - m - 1 + m
        //min(max(sum(nums[0..1]), ...))
        int[] mIdx = new int[m - 1];
        for (int i=0; i<mIdx.length; i++) {
            mIdx[i] = i + 1;
        }
        int min = Math.min(Integer.MAX_VALUE, maxGroupSum(nums, mIdx));
        while (nextIdx(mIdx, nums.length)) {
            min = Math.min(min, maxGroupSum(nums, mIdx));
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
