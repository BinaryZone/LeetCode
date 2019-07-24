package com.leetcode;

public class LeetCode006 {
	public static String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
        int m = numRows + numRows-2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < numRows;i++) {
        	int k = i;
        	boolean flag = true;
        	while(k < s.length()) {
        		sb.append(s.charAt(k));
        		if (i == 0 || i == numRows-1) {
					k = k + m; 
				}else {
					if (flag) {				
						k = k + m - i*2;
					}else {
						k = k + i * 2;
					}
					flag = !flag;
				}     		
        		
        	}        	
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}
}
