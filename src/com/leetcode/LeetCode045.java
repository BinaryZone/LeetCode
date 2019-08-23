package com.leetcode;

public class LeetCode045 {
    public static int jump(int[] nums) {
    	int len = nums.length;
    	if (len == 1) {
			return 0;
		}
        int[] index = new int[len];
        for(int i = 0;i < len;i++) {
        	index[i] = nums[i] + i;
        }
        int jump = 0;
        int count = 0;
        int maxLength = index[0];
        int maxIndex = index[0];
        while(jump < len) {
        	if (maxLength >= len - 1) {
				return count+1;
			}
        	for(int i = jump;i <= index[jump];i++) {
        		if (index[i] > maxLength) {
					maxLength = index[i];
					maxIndex = i;
				}
        	}
        	jump = maxIndex;
        	count++;
        	maxIndex = index[jump];
        }
        return count;
    }
    // ´úÂëÓÅ»¯
    public static int jump1(int[] nums) {
    	int len = nums.length;
    	int[] index = new int[len];
        if (len == 1) {
			return 0;
		}
        if (nums[0] >= len-1) {
			return 1;
		}
        for(int i = 0;i < len;i++) {
        	index[i] = nums[i] + i;
        }
        int curMaxIndex = nums[0];
        int preMaxIndex = nums[0];
        int jumpMin = 0;
        for(int i = 1;i < len;i++) {
        	if (i >= curMaxIndex) {
				jumpMin++;
				curMaxIndex = preMaxIndex;
			}
        	if (index[i] > preMaxIndex) {
				preMaxIndex = index[i];
			}
        }
        return jumpMin;
    }
    public static void main(String[] args) {
		int[] nums = {1,1,1,1,1};
		System.out.println(jump(nums));
	}
}
