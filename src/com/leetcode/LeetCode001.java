package com.leetcode;

import java.util.HashMap;

public class LeetCode001 {
	// 暴力法
	public int[] twoSum1(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			throw new IllegalArgumentException("无解");
		}
		for(int i = 0;i < nums.length;i++) {
			for(int j = i + 1;j < nums.length;j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] {i,j};
				}
			}
		}
		throw new IllegalArgumentException("无解");
	}
	
	// 利用哈希表
	public int[] twoSum2(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			throw new IllegalArgumentException("无解");
		}
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i = 0;i < nums.length;i++) {
			hm.put(nums[i],i);
		}
		for(int j = 0;j < nums.length;j++) {
			if (hm.containsKey(target - nums[j]) && hm.get(target - nums[j]) != j) {
				return new int[] {j,hm.get(target - nums[j])};
			}
		}
		throw new IllegalArgumentException("无解");
	}
	// 利用哈希表优化
	public int[] twoSum3(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			throw new IllegalArgumentException("无解");
		}
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i = 0;i < nums.length;i++) {
			if (hm.containsKey(target - nums[i]) && hm.get(target - nums[i]) != i) {
				return new int[] {i,hm.get(target - nums[i])};
			}
			hm.put(nums[i],i);
		}
		throw new IllegalArgumentException("无解");
	}
	
	
}
