package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node nextNode;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i == size - 1) {
                    cur.next = null;
                } else {
                    nextNode = queue.peek();
                    cur.next = nextNode;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return root;
    }

    Node nextStart = null;
    Node pre = null;
    Node post = null;
    // 优化空间
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            for (Node cur = start; cur != null; cur = cur.next) {
                if (cur.left != null) {
                    update(cur.left);
                }
                if (cur.right != null) {
                    update(cur.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    private void update(Node p) {
        if (nextStart == null) {
            nextStart = p;
            pre = nextStart;
            return;
        }
        if (post != null) {
            pre.next = post;
            pre = post;
            post = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
    }
}


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
