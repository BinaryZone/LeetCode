package com.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LeetCode003 {
	// 滑动窗口
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int i = 0;
		int j = 0;
		int ans = 0;
		HashSet<Character> hs = new HashSet<>();
		while(i < n && j < n) {
			if (!hs.contains(s.charAt(j))) {
				hs.add(s.charAt(j++));
				ans = Math.max(ans, j-i);
			}else {
				hs.remove(s.charAt(i++));
			}
		}
		return ans;
    }
	// 使用HashMap滑动窗口优化
	public int lengthOfLongestSubstring1(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int i = 0;
		int j = 0;
		int ans = 0;
		HashMap<Character, Integer> hm = new HashMap<>();
		while(i < n && j < n) {
			if (hm.containsKey(s.charAt(j))) {
				i = Math.max(hm.get(s.charAt(j)) + 1, i);
			}else {
				ans = Math.max(ans, j - i + 1);
			}		
			hm.put(s.charAt(j), j);
			j++;
		}
		return ans;
	}
}
