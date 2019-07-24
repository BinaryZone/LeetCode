package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode230 {
	private int count = 0;
	private int res = 0;
	// µÝ¹é
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inTraverse(root);
        return res;
    }
    public void inTraverse(TreeNode root) {
    	if (root != null) {
    		inTraverse(root.left);
    		count--;
    		if (count == 0) {
				res = root.val;
			}
    		inTraverse(root.right);
		}
	}
    // ·ÇµÝ¹é
    public int kthSmallest1(TreeNode root, int k) {
    	Deque<TreeNode> stack = new LinkedList<>();
    	int count = 0;
    	TreeNode node = root;
    	while(node != null || !stack.isEmpty()) {
    		while(node != null) {
    			stack.push(node);
    			node = node.left;
    		}
    		if (!stack.isEmpty()) {
				node = stack.pop();
				count++;
				if (count == k) {
					return node.val;
				}
				node = node.right;
			}
    	}
    	throw new RuntimeException("²ÎÊý´íÎó");
    }
}
