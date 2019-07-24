package com.leetcode;

public class LeetCode236 {
	private TreeNode LCA;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return LCA;
    }
    public boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
    	if (root == null) {
			return false;
		}
    	int left = recurseTree(root.left, p, q)?1:0;
    	int right = recurseTree(root.right, p, q)?1:0;
    	int mid = (root == p || root == q)?1:0;
    	if (left + right + mid >= 2) {
			this.LCA = root;
		}
    	return (left + right + mid) > 0;
    }
}
