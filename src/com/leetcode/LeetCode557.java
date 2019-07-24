package com.leetcode;

public class LeetCode557 {
    public String reverseWords(String s) {
    	char[] c = s.toCharArray();
        int l = 0 ;
        int r = 0;
        for(int i = 0;i < s.length();i++) {
        	if (c[i] == ' ') {
				r = i - 1;
				reverse(c, l, r);
				l = i + 1;
			}
        	if (i == s.length()-1) {
				reverse(c, l, s.length()-1);
			}
        }
        return new String(c);
    }
    public static void reverse(char[] c,int l,int r) {
        while(l < r) {
        	c[l] ^= c[r];
        	c[r] ^= c[l];
        	c[l++] ^= c[r--];
        }
	}
    public static void main(String[] args) {
		char[] a = {'a','b','c'};
		System.out.println();
	}
}
