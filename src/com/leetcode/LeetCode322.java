package com.leetcode;

import java.util.Arrays;

public class LeetCode322 {
    public static int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 0;i < amount+1;i++) {
        	dp[i] = -1;
        }
        dp[0] = 0;
        for(int i = 1;i < amount+1;i++) {
        	for(int j = 0;j < coins.length;j++) {
        		if (i - coins[j] >= 0 && dp[i-coins[j]] != -1) {
					if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1) {
						dp[i] = dp[i - coins[j]] + 1;
					}
				}
        	}
        }
        return dp[amount];
    }
	
	
	public static void main(String[] args) {
		int[] coins = {2};
		coinChange1(coins, 3);
		System.out.println(Integer.MAX_VALUE);
	}
	
	
	
	
	
	
	
	
	
	
	
	public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
			return -1;
		}
        int maxIndex = coins.length - 1;
        for(int i = coins.length - 1;i >= 0;i--) {
        	if (coins[i] <= amount) {
				maxIndex = i;
				break;
			}
        }
        int m = amount % coins[maxIndex];
        int n = amount / coins[maxIndex];
        if (m == 0) {
			return n;
		}
        for(int i = 0;i < coins.length;i++) {
        	if (m == coins[i]) {
				return n+1;
			}
        }
        return -1;
    }
}
