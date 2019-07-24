package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode155 {

}
class MinStack {
	Deque<Integer> stack1;
	Deque<Integer> stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
			stack2.push(x);
		}else if (stack2.peek() < x) {
			stack2.push(stack2.peek());
		}else {
			stack2.push(x);
		}
    }
    
    public void pop() {
    	// 最好加入空指针处理
        stack1.pop();
        stack2.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}