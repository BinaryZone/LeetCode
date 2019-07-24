package com.leetcode;

public class LeetCode021 {
	// 循环写法
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
			return null;
		}
        if (l1 == null && l2 != null) {
			return l2;
		}
        if (l1 != null && l2 == null) {
			return l1;
		}
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode head = null;
        if (l1.val < l2.val) {
			head = l1;
			node1 = l1.next;
		}else {
			head = l2;
			node2 = l2.next;
		}
        ListNode node3 = head;
        while(node1 != null && node2 != null) {
        	if (node1.val < node2.val) {
				node3.next = node1;
				node1 = node1.next;
				node3 = node3.next;
			}else {
				node3.next = node2;
				node2 = node2.next;
				node3 = node3.next;
			}
        }
        node3.next = (node1 == null?node2:node1);
        return head;
    }
	// 循环写法代码简化
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		ListNode preHead = new ListNode(-1);
		ListNode pre = preHead;
		while(l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				pre.next = l1;
				l1 = l1.next;
			}else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}
		pre.next = l1 == null ? l2: l1;
		return preHead.next;
	}
	// 递归法
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}else if (l2 == null) {
			return l1;
		}
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
