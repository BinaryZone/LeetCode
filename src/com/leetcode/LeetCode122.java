package com.leetcode;
/**
 * Best Time to Buy and Sell Stock II
 * @author DELL
 *
 */
public class LeetCode122 {
	// 贪心算法
	public int maxProfit2(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int valley = prices[0];
		int peak = prices[0];
		int maxPro = 0;
		int i = 0;
		while(i < prices.length - 1) {
			while(i < prices.length - 1 && prices[i] >= prices[i+1]) {
				i++;
			}
			valley = prices[i];
			while(i < prices.length - 1 && prices[i] <= prices[i+1]) {
				i++;
			}
			peak = prices[i];
			maxPro += peak-valley;
		}
		return maxPro;
	}
	
	
	
	
	
	
	
	
	
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int valley = prices[0];
		int peak = prices[0];
		int maxPro = 0;
		int i = 0;
		while(i < prices.length-1) {
			while(i < prices.length-1 && prices[i] >= prices[i+1]) {
				i++;
			}
			valley = prices[i];
			while(i < prices.length-1 && prices[i] <= prices[i+1]) {
				i++;
			}
			peak = prices[i];
			maxPro += (peak-valley);
		}
		return maxPro;
	}
	// 优化方案
	public int maxProfit1(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int maxPro = 0;
		for(int i = 0;i < prices.length-1;i++) {
			if (prices[i] < prices[i+1]) {
				maxPro += prices[i+1] - prices[i];
			}
		}
		return maxPro;
	}
}
