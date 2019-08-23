package com.leetcode;

public class LeetCode004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 保证nums1的长度小于等于nums2的长度
        if (m > n) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			m = nums1.length;
			n = nums2.length;
		}
        int min = 0;
        int max = m;
        // 保证两数组左右半区长度相等
        int halfLen = (m+n+1)/2;
        // 在长度小的数组上二分查找，使左半区最大元素大于右半区最小元素，同时注意边界条件。
        while(min <= max) {
        	int i = (min+max)/2;
        	int j = halfLen-i;
        	// i对应元素大了（i > min and m <= n可以推出j < max）
        	if (i > min && nums1[i-1] > nums2[j]) {
				max = i - 1;
			// i对应元素小了（与上面类似）
			}else if (i < max && nums1[i] < nums2[j-1]) {
				min = i + 1;
			}else {
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = nums2[j-1];
				}else if (j == 0) {
					maxLeft = nums1[i-1];
				}else {
					maxLeft = Math.max(nums1[i-1], nums2[j-1]);
				}
				if (((m+n)&1) == 1) {
					return maxLeft;
				}
				int minRight = 0;
				if (i == m) {
					minRight = nums2[j];
				}else if (j == n) {
					minRight = nums1[i];
				}else {
					minRight = Math.min(nums1[i], nums2[j]);
				}
				return (maxLeft+minRight)/2.0;
			}
        }
        return 0.0;
    }
}
