package leetcode.google;

public class CanJump {
    //[2,3,1,1,4]
    private boolean canJump(int idx, int[] nums) {
        if (idx >= nums.length) {
            return false;
        }
        if (idx == nums.length - 1) {
            return true;
        }
        boolean canJump = false;
        for (int i = 1; i <= nums[idx]; i++) {
            if (canJump(idx + i, nums)) {
                canJump = true;
                break;
            }
        }
        return canJump;
    }

    public boolean canJump(int[] nums) {
        return canJump(0, nums);
    }

}
