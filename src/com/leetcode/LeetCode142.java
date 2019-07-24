package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode142 {
	// 利用set额外空间
	public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
        	if (!set.contains(head)) {
				set.add(head);
			}else {
				return head;
			}
        	head = head.next;
        }
        return null;
    }
	// Floyd 算法
	public ListNode detectCycle1(ListNode head) {
		ListNode fastNode = head;
		ListNode slowNode = head;
		while(fastNode != null && fastNode.next != null && slowNode != null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
			if (fastNode == slowNode) {
				ListNode preNode = head;
				ListNode meetNode = fastNode;
				while(preNode != meetNode) {
					preNode = preNode.next;
					meetNode = meetNode.next;
				}
				return meetNode;
			}
		}
		return null;
	}
}
