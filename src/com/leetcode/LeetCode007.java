package com.leetcode;

public class LeetCode007 {
	// 1.转字符串反转，效率低，不好做溢出检验
	public static int reverse(int x) {
        String s = x + "";
        StringBuilder sb = new StringBuilder(s);
        StringBuilder result;
        if (sb.charAt(0) == '+' || sb.charAt(0) == '-') {
			String substr = sb.substring(1, sb.length());
			StringBuilder sb1 = new StringBuilder(substr);
			result = sb1.reverse().insert(0, sb.charAt(0));
		}else {
			result = sb.reverse();
		}
        if (Integer.parseInt(result.toString()) > Integer.MAX_VALUE || Integer.parseInt(result.toString()) < Integer.MIN_VALUE) {
			return 0;
		}
        return Integer.parseInt(result.toString());
    }
	// 2.利用辅助栈反转
	// 3.利用数学方法做弹出压入操作
	// pop：pop = x % 10 ;x /= 10;
	// push:temp = rev *10 + pop;rev = temp;
	public static int reverse1(int x) {
		int result = 0;
		int pop;
		while(x != 0) {
			pop = x % 10;
			x /= 10;
			if (result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && pop > 7) {
				return 0;
			}
			if (result < Integer.MIN_VALUE/10 || result == Integer.MIN_VALUE/10 && pop < -8) {
				return 0;
			}
			result = result * 10 + pop;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
}
