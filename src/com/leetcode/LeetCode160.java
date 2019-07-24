package com.leetcode;

public class LeetCode160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
			return null;
		}
        ListNode node1 = headA;
        ListNode node2 = headB;
        int countA = 0;
        int countB = 0;
        while(node1 != null) {
        	countA++;
        	node1 = node1.next;
        }
        while(node2 != null) {
        	countB++;
        	node2 = node2.next;
        }
        ListNode node3 = headA;
        ListNode node4 = headB;
        if (countA > countB) {
			for(int i = 0;i < countA - countB;i++) {
				node3 = node3.next;
			}
		}else {
			for(int i = 0;i < countB - countA;i++) {
				node4 = node4.next;
			}
		}
        while(node3 != null && node4 != null) {
        	if (node3 == node4) {
				return node3;
			}
        	node3 = node3.next;
        	node4 = node4.next;
        }
        return null;
    }
}
