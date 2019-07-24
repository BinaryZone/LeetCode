package com.leetcode;

public class LeetCode033 {
	int[] nums;
	int target;
	public int findRotateIndex(int[] nums) {
		if (nums[0] < nums[nums.length-1]) {
			return 0;
		}
		int low = 0;
		int high = nums.length-1;
		while(low <= high) {
			int mid = (low+high)/2;
//			System.out.println(mid);
			if (nums[mid] > nums[mid+1]) {
				return mid+1;
			}else if (nums[mid] < nums[low]) {
				high = mid - 1;
				
			}else {
				low = mid + 1;
			}
		}
//		System.out.println(2);
		return 0;
	}
	public int search(int left,int right) {
		while(left <= right) {
			int mid = (left+right)/2;
			if (nums[mid] == target) {
				return mid;
			}else if (nums[mid] > target) {
				right = mid-1;
			}else {
				left = mid + 1;
			}
		}
		return -1;
	}
	public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        if (nums == null) {
			return -1;
		}
        int n = nums.length;
        if (n == 0) {
			return -1;
		}
        if (n == 1) {
			return target == nums[0] ? 0:-1;
		}
        int rotate = findRotateIndex(nums);
        System.out.println(rotate);
        if (rotate == 0) {
			return search(0, nums.length-1);
		}
        if (target >= nums[0]) {
//			System.out.println(1);
			return search(0, rotate-1);
		}else {
			return search(rotate, nums.length-1);
		}
    }
	public static void main(String[] args) {
		int[] arr = {8,9,2,3,4};
		System.out.println(new LeetCode033().search(arr, 9));
	}
}
