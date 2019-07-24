package com.leetcode;

public class LeetCode008 {
	public static int myAtoi(String str) {
        if (str == null || str.trim() == "") {
			return 0;
		}
        int result = 0;
        int i = 0;
        int flag = 1;
        int len = str.length();
        while(i <len && str.charAt(i) == ' ') {
        	i++;
        }
        if (i <len && str.charAt(i) == '+') {
			flag = 1;
			i++;
		}else if (i <len && str.charAt(i) == '-') {
			flag = -1;
			i++;
		}
        if (i==len) {
			return 0;
		}
        while(i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        	if (flag == 1 && (result > Integer.MAX_VALUE/10 || 
        			result == Integer.MAX_VALUE/10 && str.charAt(i)-'0' > 7)) {
        		
        		return Integer.MAX_VALUE;
			}
        	if (flag == -1 && (-result < Integer.MIN_VALUE/10 || 
        			-result == Integer.MIN_VALUE/10 && str.charAt(i)-'0' > 8)) {
        		
				return Integer.MIN_VALUE;
			}
//        	System.out.println(result);
        	result = result*10 + (str.charAt(i) - '0');
        	i++;
        }
        return result*flag;
    }
	public static void main(String[] args) {
		System.out.println(myAtoi("-2147483649"));
	}
}
