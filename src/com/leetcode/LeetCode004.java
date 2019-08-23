package com.leetcode;

public class LeetCode004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // ��֤nums1�ĳ���С�ڵ���nums2�ĳ���
        if (m > n) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			m = nums1.length;
			n = nums2.length;
		}
        int min = 0;
        int max = m;
        // ��֤���������Ұ����������
        int halfLen = (m+n+1)/2;
        // �ڳ���С�������϶��ֲ��ң�ʹ��������Ԫ�ش����Ұ�����СԪ�أ�ͬʱע��߽�������
        while(min <= max) {
        	int i = (min+max)/2;
        	int j = halfLen-i;
        	// i��ӦԪ�ش��ˣ�i > min and m <= n�����Ƴ�j < max��
        	if (i > min && nums1[i-1] > nums2[j]) {
				max = i - 1;
			// i��ӦԪ��С�ˣ����������ƣ�
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
