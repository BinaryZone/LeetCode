package com.leetcode;

import java.util.Arrays;

public class LeetCode043 {
	public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
			return "";
		}
        if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
        int len1 = num1.length();
        int len2 = num2.length();
        int[] multi = new int[len1 + len2];
        for(int i = len1-1;i >= 0;i--) {
        	for(int j = len2-1;j >= 0;j--) {
        		int m = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        		multi[i+j] += m;
        		if (multi[i+j] >= 10 && i+j > 0){
					multi[i+j-1] += multi[i+j]/10;
					multi[i+j] = multi[i+j]%10;
				}
        	}
        }
        String s = "";
        System.out.println(Arrays.toString(multi));
        for(int i = 0;i <= len1+len2-2;i++) {
        	s+=multi[i];
        }
        return s;
    }
	public static void main(String[] args) {
		System.out.println(multiply("123", "456"));
	}
}
