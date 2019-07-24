package com.leetcode;

public class LeetCode344 {
	public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while(l < r) {
        	s[l] ^= s[r];
        	s[r] ^= s[l];
        	s[l++] ^= s[r--];
        }
    }
}
