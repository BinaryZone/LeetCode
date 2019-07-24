package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode015 {
	// 还需要优化效率
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
			return list;
		}
        Arrays.sort(nums);
        for(int i = 0;i < nums.length-2;i++) {     	
        	if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
        	int l = i+1;
        	int r = nums.length-1;
        	while(l < r) {
        		if (nums[i] > -nums[l]-nums[r]) {
        			while(l < r && nums[r] == nums[r-1]) {
        				r--;
        			}
        			r--;	
				}else if (nums[i] < -nums[l]-nums[r]) {
					while(l < r && nums[l] == nums[l+1]) {
        				l++;
					}
					l++;					
				}else {
					list.add(Arrays.asList(nums[i],nums[l],nums[r]));
					while(l < r && nums[r] == nums[r-1]) {
        				r--;
        			}
					while(l < r && nums[l] == nums[l+1]) {
        				l++;
					}
					l++;
					r--;
				}
        	}
        }
        return list;
    }

	public static void main(String[] args) {
		int[] arr = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(arr));
	}
	
}
