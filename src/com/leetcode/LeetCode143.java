package com.leetcode;

public class LeetCode143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode pre = head;
        ListNode post = head;
        while (post.next != null && post.next.next != null) {
            pre = pre.next;
            post = post.next.next;
        }
        ListNode midNext = pre.next;
        pre.next = null;
        ListNode newHead = reverse(midNext);
        merge(head, newHead);
    }

    private void merge(ListNode head, ListNode newHead) {
        ListNode node1 = head;
        ListNode node2 = newHead;
        while (node1 != null && node2 != null) {
            ListNode tmp1 = node1.next;
            ListNode tmp2 = node2.next;
            node1.next = node2;
            node2.next = tmp1;
            node1 = tmp1;
            node2 = tmp2;
        }
    }

    private ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode newHead = reverse(node.next);
        node = node.next.next;
        node.next = null;
        return newHead;
    }

}
