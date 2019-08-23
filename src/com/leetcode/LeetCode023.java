package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode023 {
	// 利用最小堆每次取所有链表中的最小值，时间复杂度O(Nlog(k))
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}    	
        });
        for(int i = 0;i < lists.length;i++) {
        	if (lists[i] != null) {
        		priorityQueue.add(lists[i]);
			}       	
        }
        ListNode node0 = new ListNode(-1);
        ListNode temp = node0;
        while(!priorityQueue.isEmpty()) {
        	ListNode node = priorityQueue.peek();
        	temp.next = priorityQueue.poll();
        	temp = temp.next;
        	if (node.next != null) {
        		priorityQueue.add(node.next);
			}      	
        }
        return node0.next;
    }
    // 分治+合并
    public ListNode mergeKLists1(ListNode[] lists) {
    	if (lists == null || lists.length == 0) {
			return null;
		}
    	int low = 0;
    	int high = lists.length - 1;
    	return split(lists, low, high);
    }
    private static ListNode split(ListNode[] lists,int low,int high) {
    	if (low >= high) {
			return lists[low];
		}
    	int mid = (low + high)/2;
    	ListNode node1 = split(lists, low, mid);
    	ListNode node2 = split(lists, mid+1, high);
    	return merge(node1, node2);
    }
    private static ListNode merge(ListNode node1,ListNode node2) {
		ListNode node0 = new ListNode(-1);
		ListNode temp = node0;
		while(node1 != null && node2 != null) {
			if (node1.val > node2.val) {
				temp.next = node2;
				node2 = node2.next;
			}else {
				temp.next = node1;
				node1 = node1.next;
			}
			temp = temp.next;
		}
		if (node1 == null) {
			temp.next = node2;
		}
		if (node2 == null) {
			temp.next = node1;
		}
		return node0.next;
	}
}
