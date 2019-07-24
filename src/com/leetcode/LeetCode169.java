package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode169 {
	// 1.排序后取中间数
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    // 2.利用map
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer num:nums) {
        	if (!map.containsKey(num)) {
				map.put(num, 1);
			}else {
				map.put(num, map.get(num)+1);
			}
        }
        for(Integer key:map.keySet()) {
        	if (map.get(key) > nums.length/2) {
				return key;
			}
        }
        return -1;
    }
}
