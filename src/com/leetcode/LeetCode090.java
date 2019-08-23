package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode090 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		result.add(temp);
		Arrays.sort(nums);
		return helper(nums, 0, result, temp, set);
    }
	public static List<List<Integer>> helper(int[] nums,int i,List<List<Integer>> result,List<Integer> temp,Set<List<Integer>> set) {
		if (i >= nums.length) {
			return null;
		}
		temp.add(nums[i]);
		if (!set.contains(temp)) {
			result.add(new ArrayList<>(temp));
			set.add(new ArrayList<>(temp));
		}
		helper(nums, i+1, result, temp, set);
		temp.remove(temp.size()-1);
		helper(nums, i+1, result, temp, set);
		return result;
	}
}
