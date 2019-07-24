package com.leetcode;

public class LeetCode002 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node1 = l1;
		ListNode node2 = l2;
		ListNode newNode = new ListNode(0);
		ListNode curNode = newNode;
		int carry = 0;
        while(node1 != null || node2 != null) {
        	int x = (node1 == null)? 0:node1.val;
        	int y = (node2 == null)? 0:node2.val;
        	int value = (x + y + carry)%10;
        	carry = (x + y + carry)/10;
        	curNode.next = new ListNode(value);
        	curNode = curNode.next;
        	if (node1 != null) {
        		node1 = node1.next;
			}
        	if (node2 != null) {
        		node2 = node2.next;
			}      	
        }
        if (carry > 0) {
			curNode.next = new ListNode(carry);
		}
        return newNode.next;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }