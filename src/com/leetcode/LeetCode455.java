package com.leetcode;

import java.util.Arrays;

public class LeetCode455 {
	public static void main(String[] args) {
		
	}
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while(i < g.length && j < s.length) {
        	if (s[j] >= g[i]) {
				i++;
			}
        	j++;
        }
        return i;
    }
}
