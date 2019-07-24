package com.leetcode;

public class LeetCode061 {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		int len = 0;
		ListNode node = head;
		while(node != null) {
			len++;
			node = node.next;
		}
		if (k > len) {
			k = k % len;
		}
		if (k == 0) {
			return head;
		}
        ListNode frontNode = head;
        ListNode behindNode = head;
        for(int i = 0;i < k;i++) {
        	frontNode = frontNode.next;
        }
        while(frontNode.next != null) {
        	frontNode = frontNode.next;
        	behindNode = behindNode.next;
        }
        ListNode rotateHead = behindNode.next;
        frontNode.next = head;
        behindNode.next = null;
        return rotateHead;
     }
	
}
