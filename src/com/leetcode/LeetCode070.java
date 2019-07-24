package com.leetcode;

public class LeetCode070 {
	public int climbStairs1(int n) {
		int[] dp = new int[n];
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		dp[0] = 1;
		dp[1] = 2;
		for(int i = 2;i < n;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n-1];
	}
	// ตÝน้
	public int climbStairs2(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return climbStairs2(n-1) + climbStairs2(n-2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public int climbStairs(int n) {
        int[] count = new int[n+1];
        if (n == 1) {
			return 1;
		}
        if (n == 2) {
			return 2;
		}
        count[1] = 1;
        count[2] = 2;
        for(int i = 3;i <= n;i++) {
        	count[i] = count[i-1] + count[i-2];
        }
        return count[n];
    }
}
