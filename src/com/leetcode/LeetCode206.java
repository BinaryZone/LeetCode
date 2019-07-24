package com.leetcode;

public class LeetCode206 {
	// ѭ��
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
			return head;
		}
        ListNode curNode = head;
        ListNode preNode = null;
        ListNode postNode = curNode.next;
        while(curNode != null) {
        	curNode.next = preNode;
        	preNode = curNode;
        	curNode = postNode;
        	if (postNode != null) {
        		postNode = postNode.next;
			}       	
        }
        return preNode;
    }
    // �ݹ�
    public ListNode reverseList1(ListNode head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
