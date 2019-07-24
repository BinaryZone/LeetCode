package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode104 {
	// 1.≤„–Ú±È¿˙
	public int maxDepth(TreeNode root) {
        if (root == null) {
			return 0;
		}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        int count;
        int depth = 0;
        while(!queue.isEmpty()) {
        	count = queue.size();
        	for(int i = 0;i < count;i++) {
        		node = queue.poll();
            	if (node.left != null) {
    				queue.add(node.left);
    			}
            	if (node.right != null) {
    				queue.add(node.right);
    			}
        	}
        	depth++;
        }
        return depth;
    }
	// 2.µ›πÈ
	public int maxDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}else {
			int leftDepth = maxDepth1(root.left);
			int rightDepth = maxDepth1(root.right);
			return Math.max(leftDepth, rightDepth)+1;
		}
	}
}
