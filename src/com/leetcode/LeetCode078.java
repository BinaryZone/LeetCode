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
}
