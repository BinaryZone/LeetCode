package com.leetcode;

public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) {
            return null;
        }
        return recursion(inorder, 0, len - 1, postorder, 0, len - 1);
    }
    private TreeNode recursion(int[] inorder, int ina, int inb ,int[] postOrder, int posta,int postb) {
        if (ina > inb || posta > postb) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postb]);
        if (ina == inb || posta == postb) {
            return root;
        }
        int mid = ina;
        while (mid <= inb && inorder[mid] != postOrder[postb]) {
            mid++;
        }
        root.left = recursion(inorder, ina, mid - 1, postOrder, posta, posta + mid - ina - 1);
        root.right = recursion(inorder, mid + 1, inb, postOrder, posta + mid - ina, postb - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {2,1};
        int[] postorder = {2,1};
        new LeetCode106().buildTree(inorder, postorder);
    }
}
