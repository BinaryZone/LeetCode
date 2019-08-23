package com.leetcode;

import java.util.Arrays;

public class LeetCode005 {
	// ������  
//	public String longestPalindrome(String s) {
//		
//    }
	// DP
	public static String longestPalindrome1(String s) {
		if (s == null) {
			return null;
		}
		int len = s.length();
		if (len < 2) {
			return s;
		}
		boolean[][] flag = new boolean[len][len];
		String result = s.charAt(0) + "";
		// ��ʼ��������ĸ�����
		for(int i = 0;i < len;i++) {
			flag[i][i] = true;
		}
		// ��ʼ��������ĸ�����
		for(int i = 0;i < len - 1;i++) {
			if (s.charAt(i) == s.charAt(i+1)) {
				flag[i][i+1] = true;
			}
			if (flag[i][i+1] == true && result.length() < 2) {
				result = s.substring(i, i+2);
			}
		}
		for(int k = 2;k < len;k++) {
			for(int i = 0;i < len - k;i++) {
				if (s.charAt(i) == s.charAt(i+k) && flag[i+1][i+k-1]) {
					flag[i][i+k] = true;
				}
				if (flag[i][i+k] && result.length() < k+1) {
					result = s.substring(i, i+k+1);
				}
			}
		}
		return result;
	}
	// DP
	public String longestPalindrome(String s) {
        if (s == null) {
			return "";
		}
        int len = s.length();
        if (len < 2) {
			return s;
		}
        String result = s.charAt(0) +"";
        boolean[][] flag = new boolean[len][len];
        for(int i = 0;i <len;i++) {
        	flag[i][i] = true;
        }
        for(int i = 0;i < len-1;i++) {
        	flag[i][i+1] = s.charAt(i) == s.charAt(i+1);
        	if (flag[i][i+1] && result.length() < 2) {
				result = s.substring(i, i+2);
			}
        }
        for(int k = 3;k <= len;k++) {
        	for(int i = 0;i < len - k + 1;i++) {
        		if (s.charAt(i) == s.charAt(i+k-1) && flag[i+1][i+k-2]) {
					flag[i][i+k-1] = true;
				}
        		if (flag[i][i+k-1] && result.length() < k) {
					result = s.substring(i, i+k);
				}
        	}
        }
        return result;
    }
	
	// ��������ⲹ��
		// �ж�һ���ַ����Ƿ��ǻ���
		public static boolean isPalinDrome(String s) {
			if (s == null) {
				return false;
			}
			int len = s.length();
			int i = 0;
			for(;i < len/2 && s.charAt(i) == s.charAt(len-i-1);i++) {}
			return i == len/2;
		}
		// ����һ���ַ������ж�һ���ַ������Ƿ��л���(��ȥ�����ַ�)
			
		public static boolean hasPalinDrome(String s) {
			if (s == null) {
				return false;
			}
			for(int i = 0;i < s.length()-1;i++) {
				if (s.charAt(i) == s.charAt(i+1) || i-1 >= 0 && s.charAt(i-1) == s.charAt(i+1)) {
					return true;
				}
			}
			return false;
		}
	public static void main(String[] args) {
//		System.out.println(isPalinDrome("bbbbbb"));
//		System.out.println(hasPalinDrome("cabad"));
		System.out.println(longestPalindrome1("babad"));
	}
}
