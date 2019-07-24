package com.leetcode;

public class LeetCode235 {
	// �ݹ�д��
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		}else if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}else {
			return root;
		}
    }
    // ѭ��д��
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
    	throw new RuntimeException("���벻�Ϸ�");
    }
}
