package com.leetcode;

public class LeetCode235 {
	// 递归写法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		}else if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}else {
			return root;
		}
    }
    // 循环写法
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    	TreeNode node = root;
    	while(node != null) {
    		if (p.val > node.val && q.val > node.val) {
				node = node.right;
			}else if (p.val < node.val && q.val < node.val) {
				node = node.left;
			}else {
				return node;
			}
    	}
    	throw new RuntimeException("输入不合法");
    }
}
