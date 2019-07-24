package com.leetcode;
/**
 * 121.Best Time to Buy and Sell Stock
 * @author DELL
 *
 */
public class LeetCode121 {
	public static int maxProfit1(int[] prices) {
		int maxPro = 0;
		int minPrice = Integer.MAX_VALUE;
		for(int num:prices) {
			if (num < minPrice) {
				minPrice = num;
			}else {
				maxPro = Math.max(maxPro, num-minPrice);
			}
		}
		return maxPro;
	}
	
	
	
	/**
	 * T(n) = O(n**2)
	 * S(n) = O(1)
	 * @param price
	 * @return
	 */
	public static int maxProfit(int[] price) {
		int maxprofit = 0;
		for(int i=0; i<price.length-1;i++) {
			for(int j=i+1;j<price.length;j++) {
				int profit = price[j] - price[i];
				if (profit>maxprofit) {
					maxprofit = profit;
				}
			}
		}
		return maxprofit;
	}
	
	/**
	 * T(n) = O(n)
	 * S(n) = O(1)
	 * @param price
	 * @return
	 */
	public static int maxProfit01(int[] price) {
		int minprice = Integer.MAX_VALUE;
		int maxprice = 0;
		for(int i=0;i<price.length;i++) {
			if (price[i]<minprice) {
				minprice = price[i];
			}else if (price[i] - minprice>maxprice) {
				maxprice = price[i] - minprice;
			}
		}
		return maxprice;
		
	}
	
	public static void main(String[] args) {
		int[] price = {7,1,5,3,6,4};
		System.out.println(maxProfit(price));
		System.out.println(maxProfit01(price));
	}
}
