package com.leetcode;

public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0;i < nums.length;i++) {
        	res[i] = k;
        	k = k * nums[i];
        }
        k = 1;
        for(int i = nums.length-1;i >= 0;i--) {
        	res[i] = res[i] * k;
        	k = k * nums[i];
        }
        return res;
    }
}
