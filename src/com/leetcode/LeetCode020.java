package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode020 {
	public static boolean isValid(String s) {
        if (s == null) {
			return false;
		}
        Deque<Character> stack = new LinkedList<>();
        int i = 0;
        while(i < s.length()) {
        	char c = s.charAt(i);
        	if (c == '(' || c == '[' || c == '{') {
        		
				stack.push(c);
			}else if (stack.isEmpty()) {
				return false;
			}else {
				char c1 = stack.peek();
				if (c == ')' && c1 == '(' || c == ']' && c1 == '[' || c == '}' && c1 == '{') {
					stack.pop();
				}else {
					stack.push(c);
				}
			}
        	i++;
        }
        return stack.isEmpty();
    }
	public static void main(String[] args) {
		System.out.println(isValid("]"));
	}
}
