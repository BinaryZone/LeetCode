package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode078 {
	// 1.位运算
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i < (1<<nums.length);i++) {
        	List<Integer> arr = new ArrayList<>();
        	for(int j = 0;j < nums.length;j++) {
        		if (((i>>j)&1) == 1) {
					arr.add(nums[j]);
				}
        	}
        	result.add(arr);
        }
        return result;
    }
	// 2.回溯法
	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		traceBack(nums, 0, result, new ArrayList<>());
		return result;
	}
	public static void traceBack(int[] nums,int start,List<List<Integer>> result,List<Integer> temp) {
		result.add(new ArrayList<>(temp));
		for(int i = start;i < nums.length;i++) {
			temp.add(nums[i]);
			traceBack(nums, i+1, result, temp);
			temp.remove(temp.size()-1);
		}
	}
	
	// 回溯法2
	public List<List<Integer>> subsets3(int[] nums) {
		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		result.add(temp);
		return helper(nums, 0, temp,result);
	}
	public static List<List<Integer>> helper(int[] nums,int i,List<Integer> temp,List<List<Integer>> result) {
		if (i >= nums.length) {
			return null;
		}
		temp.add(nums[i]);
		result.add(new ArrayList<>(temp));
		helper(nums, i+1,temp, result);
		temp.remove(temp.size()-1);
		helper(nums, i+1, temp, result);
		return result;
	}
	
	// 位运算
	public List<List<Integer>> subsets4(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0;i < 1<<nums.length;i++) {
			List<Integer> temp = new ArrayList<>();
			for(int j = 0;j < nums.length;j++) {
				if ((i & (1<<j)) > 0) {
					temp.add(nums[j]);
				}
			}
			result.add(temp);
		}
		return result;
	}
}
