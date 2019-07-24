package com.leetcode;

public class LeetCode059 {
	public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int r1 = 0;
        int c1 = 0;
        int r2 = n-1;
        int c2 = n-1;
        int k = 1;
        while(r1 <= r2 && c1 <= c2) {
        	for(int i = c1;i <= c2;i++) {
        		ans[r1][i] = k;
        		k++;
        	}
        	for(int j = r1+1;j <= r2;j++) {
        		ans[j][c2] = k;
        		k++;
        	}
        	if (r2 -r1 > 0 && c2 - c1 > 0) {
				for(int m = c2-1;m >= c1;m--) {
					ans[r2][m] = k;
	        		k++;
				}
				for(int l = r2-1;l >= r1+1;l--) {
					ans[l][c1] = k;
	        		k++;
				}
			}
        	r1++;
        	c1++;
        	r2--;
        	c2--;
        }
        return ans;
    }
}
