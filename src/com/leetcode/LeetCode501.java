package com.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode501 {
    Map<Integer,Integer> map = new HashMap<>();
    // 暴力解法
    public int[] findMode(TreeNode root) {
        recursion(root);
        ArrayList<Integer> arr = new ArrayList<>();
        int maxNum = 0;
        for (Integer num : map.keySet()) {
            if (map.get(num) > maxNum) {
                maxNum = map.get(num);
            }
        }
        for (Integer num : map.keySet()) {
            if (map.get(num) == maxNum) {
                arr.add(num);
            }
        }
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
    private void recursion (TreeNode root) {
        if (root == null) {
            return;
        }
        recursion(root.left);
        int key = root.val;
        int value = map.getOrDefault(key, 0);
        map.put(key, value + 1);
        recursion(root.right);
    }

    // morris中序遍历
    int base;
    int count;
    int maxCount;
    List<Integer> res = new ArrayList<>();
    public int[] findMode1(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            // 如果当前节点无左孩子，直接更新
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            // 当前节点有左孩子，寻找cur的前序节点
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            // 第一遍遇到
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else { // 第二遍遇到
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    private void update(int val) {
        if (val == base) {
            count++;
        } else {
            base = val;
            count = 1;
        }
        if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(base);
        } else if (count == maxCount) {
            res.add(base);
        }
    }
}
