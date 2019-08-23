package com.leetcode;

public class LeetCode376 {
	public int wiggleMaxLength(int[] nums) {
		if (nums == null || nums.length < 2) {
			return nums.length;
		}
		int begin = 0;
		int up = 1;
		int down = 2;
		int status = begin;
		int maxLength = 1;
		for(int i = 0;i < nums.length-1;i++) {
			switch (status) {
			case 0:
				if (nums[i] < nums[i+1]) {
					status = up;
					maxLength++;
				}else if (nums[i] > nums[i+1]) {
					status = down;
					maxLength++;
				}
				break;
			case 1:
				if (nums[i] > nums[i+1]) {
					status = down;
					maxLength++;
				}
				break;
			case 2:
				if (nums[i] < nums[i+1]) {
					status = up;
					maxLength++;
				}
				break;
			default:
				break;
			}
		}
		return maxLength;
	}
}
