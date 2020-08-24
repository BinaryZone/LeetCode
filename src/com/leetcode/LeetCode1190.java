package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1190 {
    public String reverseParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int n = s.length();
        int[] pair = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0,d = 1; i < n; i+=d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
