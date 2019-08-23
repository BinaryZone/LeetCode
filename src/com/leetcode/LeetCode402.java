package com.leetcode;

import java.util.LinkedList;

public class LeetCode402 {
    public String removeKdigits(String num, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        String result = "";
        for(int i = 0;i < num.length();i++) {
        	int m = num.charAt(i) - '0';
        	while(!stack.isEmpty() && m < stack.getLast() && k > 0) {
        		stack.removeLast();
        		k--;
        	}
        	if (m != 0 || stack.size() != 0) {
				stack.add(m);
			}
        }
        while(stack.size() != 0 && k > 0) {
        	stack.removeLast();
        	k--;
        }
        for(int i = 0;i < stack.size();i++) {
        	result += stack.get(i);
        }
        if (result == "") {
			result = "0";
		}
        return result;
    }
}
