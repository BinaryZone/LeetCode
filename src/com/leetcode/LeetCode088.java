package com.leetcode;

import java.util.Arrays;

public class LeetCode088 {
	// 1.双指针从前往后，主要要在nums1上操作
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m];
        System.arraycopy(nums1, 0, arr, 0, m);
        int k = 0;
        int i = 0;
        int j = 0;
        while(i < m && j < n) {
        	if (arr[i] < nums2[j]) {
				nums1[k] = arr[i];
				i++;
			}else {
				nums1[k] = nums2[j];
				j++;
			}
        	k++;
        }
//        System.out.println(i);
//        System.out.println(j);
        if (i < m) {
			System.arraycopy(arr, i, nums1, k, m-i);
		}
        if (j < n) {
        	System.arraycopy(nums2, j, nums1, k, n-j);
		}
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(nums1));
//        System.out.println(Arrays.toString(nums1));
    }
	
	// 2.双指针，从后往前
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1;
		int j = n-1;
		int k = m + n - 1;
		while(i >=0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k] = nums1[i];
				i--;
			}else {
				nums1[k] = nums2[j];
				j--;
			}
			k--;
		}
		if (j >= 0) {
			System.arraycopy(nums2, 0, nums1, 0, j+1);
		}
	}
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		merge(nums1, 3, nums2, 3);
	}
}
