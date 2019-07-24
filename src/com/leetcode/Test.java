package com.leetcode;

public class Test {
	// Ñ­»·Ð´·¨
	public void reverseString(char[] s) {
        int l = 0;
        int r = s.length-1;
        while(l < r) {
        	char temp = s[l];
        	s[l] = s[r];
        	s[r] = temp;
        }
    }
	public void reverseString1(char[] s) {
        int l = 0;
        int r = s.length-1;
        helper(s, l, r);
    }
	public static void helper(char[] s,int l,int r) {
		
	}
	public static void main(String[] args) {
		String s1 = "123";
		System.out.println(Integer.parseInt(s1));
	}
}
