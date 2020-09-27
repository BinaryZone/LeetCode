package com.leetcode;

public class LeetCode152 {
    // 空间还可优化
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            max[i] = Math.max(num, Math.max(num * max[i-1], num * min[i-1]));
            min[i] = Math.min(num, Math.min(num * max[i-1], num * min[i-1]));
        }
        int ans = Integer.MIN_VALUE;
        for (int maxnum : max) {
            if (maxnum > ans) {
                ans = maxnum;
            }
        }
        return ans;
    }
}
