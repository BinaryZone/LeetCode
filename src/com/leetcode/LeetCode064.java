package com.leetcode;

public class LeetCode064 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int sum = 0;
        for(int i = 0;i < dp.length;i++) {
        	sum += grid[i][0];
        	dp[i][0] = sum;
        }
        sum = 0;
        for(int i = 0;i < dp[0].length;i++) {
        	sum += grid[0][i];
        	dp[0][i] = sum;
        }
        for(int i = 1;i < dp.length;i++) {
        	for(int j = 1;j < dp[0].length;j++) {
        		dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
        	}
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
