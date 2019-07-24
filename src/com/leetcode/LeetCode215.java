package com.leetcode;

import java.util.PriorityQueue;

public class LeetCode215 {
	// 1.ÀûÓÃpartitionº¯Êý
    public int findKthLargest(int[] nums, int k) {
    	int low = 0;
    	int high = nums.length - 1;
        int index = partition(nums, low, high);
        while(index != nums.length-k) {
        	if (index > nums.length-k) {
				index = partition(nums, low, index-1);
			}else {
				index = partition(nums, index+1, high);
			}
        }
        return nums[index];
    }
    public static int partition(int[] nums,int low,int high) {
		int x = nums[low];
		int i = low;
		int j = high;
		while(i < j) {
			while(nums[j] >= x && i < j) {
				j--;
			}
			if (i < j) {
				nums[i] = nums[j];
				i++;
			}
			while(nums[i] <= x && i < j) {
				i++;
			}
			if (i < j) {
				nums[j] = nums[i];
				j--;
			}
		}
		nums[i] = x;
		return i;
	}
    
    public int findKthLargest1(int[] nums, int k) {
    	PriorityQueue<Integer> heap = new PriorityQueue<>();
    	for(int n:nums) {
    		heap.add(n);
    		if (heap.size() > k) {
				heap.poll();
			}
    	}
    	return heap.poll();
    }
}
