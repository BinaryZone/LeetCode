package com.leetcode;

public class LeetCode141 {
	// ¿ìÂýÖ¸Õë
	public boolean hasCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode != null && slowNode != null && fastNode.next != null) {
        	fastNode = fastNode.next.next;
        	slowNode = slowNode.next;
        	if (fastNode == slowNode) {
				return true;
			}
        }
        return false;
    }
	
	// ¹þÏ£±í
}
