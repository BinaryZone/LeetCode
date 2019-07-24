package com.leetcode;

import java.util.Arrays;

public class LeetCode016 {
	public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
			throw new RuntimeException("ÊäÈë²»¹æ·¶");
		}
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0;i < nums.length;i++) {
        	int l = i+1;
        	int r = nums.length-1;
        	while(l < r) {
        		if (nums[i] + nums[l] + nums[r] == target) {
					return nums[i] + nums[l] + nums[r];
				}
        		if (Math.abs(nums[i] + nums[l] + nums[r]-target) < Math.abs(result-target)) {
					result = nums[i] + nums[l] + nums[r];
				}
        		if (nums[i] + nums[l] + nums[r] > target) {				
					r--;					
				}else {
					l++;
				}
        	}
        }
        return result;
    }
}
