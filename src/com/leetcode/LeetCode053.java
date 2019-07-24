package com.leetcode;

public class LeetCode053 {
	public int maxSubArray1(int[] nums) {
		int ans = nums[0];
		int sum = 0;
		for(int num:nums) {
			if (sum > 0) {
				sum += num;
			}else {
				sum = num;
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}
	// DP
	public int maxSubArray2(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for(int i = 1;i < dp.length;i++) {
			int A = nums[i];
			int sum = nums[i];
			for(int j = i-1;j >= 0;j--) {
				if ((sum += nums[j]) > A) {
					A = sum;
				}
			}
			dp[i] = Math.max(A, dp[i-1]);
		}
		return dp[dp.length-1];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num:nums) {
        	if (sum > 0) {
				sum += num;
			}else {
				sum = num;
			}
        	ans = Math.max(ans, sum);
        }
        return ans;
    }
}
