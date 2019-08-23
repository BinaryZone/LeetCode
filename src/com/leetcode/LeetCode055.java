package com.leetcode;

import java.util.Arrays;

public class LeetCode055 {
    public static boolean canJump(int[] nums) {
    	int len = nums.length;
        int[] index = new int[len];
        for(int i = 0;i < len;i++) {
        	index[i] = i + nums[i];
        }
        int jump = 0;
        int maxIndex = index[0];
        while(jump < len && jump <= maxIndex) {
        	if (index[jump] > maxIndex) {
				maxIndex = index[jump];
			}
        	jump++;
        }
        System.out.println(jump);
        System.out.println(maxIndex);
        System.out.println(Arrays.toString(index));
        if (jump == len-1) {
			return true;
		} 
        return false;
    }
    public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		canJump(nums);
	}
}
