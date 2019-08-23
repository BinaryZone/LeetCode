package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode040 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		int sum = 0;
		Arrays.sort(candidates);
		helper(candidates, 0, result, temp, set, sum, target);
		return result;
    }
	public static List<List<Integer>> helper(int[] candidates,int i,List<List<Integer>> result,List<Integer> temp,Set<List<Integer>> set,int sum,int target) {
		if (i >= candidates.length && sum > target) {
			return null;
		}
		temp.add(candidates[i]);
		sum += candidates[i];
		if (sum == target && !set.contains(temp)) {
			result.add(new ArrayList<>(temp));
			set.add(new ArrayList<>(temp));
		}
		if (sum < target) {
			helper(candidates, i+1, result, temp, set, sum,target);
		}	
		temp.remove(temp.size()-1);
		sum -= candidates[i];
		if (sum < target) {
			helper(candidates, i+1, result, temp, set, sum,target);
		}
		return result;
	}
}
