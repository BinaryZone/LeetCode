package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// 二叉树的垂直遍历
public class LeetCode314 {
	public static List<ArrayList<Integer>> print(TreeNode root) {
		List<ArrayList<Integer>> res = new ArrayList<>();
		Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
		helper(root, 0, map);
		for(Integer key:map.keySet()) {
			res.add(map.get(key));
		}
		return res;
	}
	private static void helper(TreeNode root,int key,Map<Integer, ArrayList<Integer>> map) {
		if (root == null) {
			return;
		}
		if (map.containsKey(key)) {
			map.get(key).add(root.val);
		}else {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(root.val);
			map.put(key, list);
		}
		helper(root.left, key-1, map);
		helper(root.right, key+1, map);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		List<ArrayList<Integer>> list = print(root);
		for(ArrayList<Integer> list2:list) {
			System.out.println(list2);
		}
	}
}
