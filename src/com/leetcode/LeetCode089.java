package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode089 {
	// 1.¶¯Ì¬¹æ»®
	public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i = 0;i < n;i++) {
        	int add = 1 << i;
        	for(int j = list.size()-1;j >=0;j--) {
        		list.add(list.get(j)+add);
        	}
        }
        return list;
    }
}
