package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode300 {
	// dp
    public int lengthOfLIS(int[] nums) {
    	if (nums == null || nums.length < 1) {
			return 0;
		}
        int[] dp = new int[nums.length];
        for(int i = 0;i < dp.length;i++) {
        	dp[i] = 1;
        }
        int result = dp[0];
        for(int i = 1;i < dp.length;i++) {
        	for(int j = 0;j < i;j++) {
        		if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
        	}
        	if (result < dp[i]) {
				result = dp[i];
			}
        }
        return result;
    }
    // dp+¶þ·Ö²éÕÒ
    public int lengthOfLIS1(int[] nums) {
    	if (nums == null || nums.length < 1) {
			return 0;
		}
    	int[] dp = new int[nums.length];
    	int len = 0;
    	for(int num:nums) {
    		int i = Arrays.binarySearch(dp, 0, len, num);
    		if (i < 0) {
				i = -i-1;
			}
    		dp[i] = num;
    		if (i == len) {
				len++;
			}
    	}
    	return len;
    }
    
}
