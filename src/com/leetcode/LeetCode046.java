package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode046 {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list1 = new LinkedList<>();
        if (nums == null || nums.length == 0) {
			return list1;
		}
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        for(int num:nums) {
        	arr.add(num);
        }
        backTrack(n, list1, arr, 0);
        return list1;
    }
	public void backTrack(int n,List<List<Integer>> list,List<Integer> arr,int first) {
		if (first == n) {
			list.add(new ArrayList<>(arr));
		}
		for(int i = first;i < n;i++) {
			Collections.swap(arr, first, i);
			backTrack(n, list,arr, first+1);
			Collections.swap(arr, first, i);
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(new LeetCode046().permute(nums));
	}
}
