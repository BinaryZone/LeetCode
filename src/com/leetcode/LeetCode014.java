package com.leetcode;

public class LeetCode014 {
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
			return "";
		}
        String result = strs[0];
        for(int i = 1;i < strs.length;i++) {
        	int j = 0;
        	while(j < strs[i].length() && j < result.length()) {
        		if (j == 0 && strs[i].charAt(j) != result.charAt(j)) {
					return "";
				}else if (strs[i].charAt(j) == result.charAt(j)) {
					j++;
				}else if (strs[i].charAt(j) != result.charAt(j)) {
					break;
				}
        	}
        	result = result.substring(0, j);
        }
        return result;
    }
	// 优化方式1：优化找公共子串的方式
	public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
			return "";
		}
        String result = strs[0];
        for(int i = 1;i < strs.length;i++) {
        	while(strs[i].indexOf(result) != 0) {
        		result = result.substring(0, result.length()-1);
        		if (result == "") {
					return "";
				}
        	}
        }
        return result;
	}
	// 优化方法2：水平扫描
	public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
			return "";
		}
        for(int i = 0;i < strs[0].length();i++) {
        	char c = strs[0].charAt(i);
        	for(int j = 1;j < strs.length;j++) {
        		if (i == strs[j].length() || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
        	}
        }
        return strs[0];
	}
}
