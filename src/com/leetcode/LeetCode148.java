package com.leetcode;

public class LeetCode148 {
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
			return head;
		}
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(right));
    }
	public ListNode getMid(ListNode head) {
		ListNode fastNode = head;
		ListNode slowNode = head;
		while(fastNode.next != null && fastNode.next.next != null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		return slowNode;
	}
	public ListNode merge(ListNode head1,ListNode head2) {
		ListNode node1 = head1;
		ListNode node2 = head2;
		ListNode head;
		if (node1.val < node2.val) {
			head = node1;
			node1 = node1.next;
		}else {
			head = node2;
			node2 = node2.next;
		}
		ListNode node = head;
		while(node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				node.next = node1;
				node1 = node1.next;
			}else {
				node.next = node2;
				node2 = node2.next;
			}
			node = node.next;
		}
		if (node1 != null) {
			node.next = node1;
		}
		if (node2 != null) {
			node.next = node2;
		}
		return head;
	}
}
