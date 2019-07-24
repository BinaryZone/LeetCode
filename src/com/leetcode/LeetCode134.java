package com.leetcode;

public class LeetCode134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length <= 0 || cost.length <= 0) {
			return -1;
		}
        int remain = 0;
        int rest = 0;
        int index = 0;
        for(int i = 0;i < gas.length;i++) {
        	remain += gas[i] - cost[i];
        	rest += gas[i] - cost[i];
        	if (rest < 0) {
				rest = 0;
				index = i + 1;
			}
        }
        return remain >= 0?index:-1; 
    }
}
