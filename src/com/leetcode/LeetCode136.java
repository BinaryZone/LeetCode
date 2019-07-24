package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode136 {
	// 1.ʹ�ù�ϣ��
	public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer num:nums) {
        	if (!map.containsKey(num)) {
				map.put(num, 1);
			}else {
				map.remove(num);
			}
        }
        for(Integer key:map.keySet()) {
        	if (map.get(key) == 1) {
				return key;
			}
        }
        return -1;
    }
	// 2.����λ���㣬��ʹ�ö���ռ�
	public int singleNumber1(int[] nums) {
        int a = 0;
        for(Integer num:nums) {
        	a ^= num;
        }
        return a;
    }
}
