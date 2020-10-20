package com.leetcode;

public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] flag = new boolean[len][target + 1];
        for (int j = 1; j <= target; j++) {
            if (nums[0] == target) {
                flag[0][j] = true;
            }
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= target; j++) {
                boolean flag1 = flag[i - 1][j];
                boolean flag2 = false;
                if (j == nums[i]) {
                    flag2 = true;
                }
                boolean flag3 = false;
                if (j > nums[i]) {
                    flag3 = flag[i - 1][j - nums[i]];
                }
                flag[i][j] = flag1 || flag2 || flag3;
            }
        }
        return flag[len - 1][target];
    }
}
