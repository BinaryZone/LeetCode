package com.leetcode;

public class LeetCode075 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int cur = 0;
        int p0 = 0;
        int p2 = len - 1;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                exchange(nums,cur,p0);
                p0++;
                cur++;
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                exchange(nums,cur,p2);
                p2--;
            }
        }
    }
    private void exchange(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
