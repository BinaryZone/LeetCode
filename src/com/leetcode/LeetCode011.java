package com.leetcode;

public class LeetCode011 {
	public int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
        int area = 0;
        int l = 0;
        int r = height.length-1;
        while(l < r) {
        	if (height[l] < height[r]) {
				if (height[l] * (r-l) > area) {
					area = height[l] * (r-l);
				}
				l++;
			}else {
				if (height[r] * (r-l) > area) {
					area = height[r] * (r-l);
				}
				r--;
			}
        }
        return area;
    }
	// ´úÂëÓÅ»¯
	public int maxArea1(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
        int area = 0;
        int l = 0;
        int r = height.length-1;
        while(l < r) {
        	area = Math.max(area, Math.min(height[l], height[r])*(r-l));
        	if (height[l] < height[r]) {
				l++;
			}else {
				r--;
			}
        }
        return area;
    }
}
