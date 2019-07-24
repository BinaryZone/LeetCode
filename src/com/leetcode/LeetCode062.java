package com.leetcode;

public class LeetCode062 {
	public int uniquePaths1(int m, int n) {
		int[][] count = new int[m][n];
		for(int i = 0;i < m;i++) {
			count[i][0] = 1;
		}
		for(int i = 0;i < n;i++) {
			count[0][i] = 1;
		}
		for(int i = 1;i < m;i++) {
			for(int j = 1;j < n;j++) {
				count[i][j] = count[i-1][j] + count[i][j-1];
			}
		}
		return count[m-1][n-1];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++) {
        	dp[i][0] = 1;
        }
        for(int j = 0;j < n;j++) {
        	dp[0][j] = 1;
        }
        for(int k = 1;k < m;k++) {
        	for(int l = 1;l < n;l++) {
        		dp[k][l] = dp[k-1][l] + dp[k][l-1];
        	}
        }
        return dp[m-1][n-1];
    }
}
