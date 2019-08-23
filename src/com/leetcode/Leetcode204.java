package com.leetcode;

public class Leetcode204 {
	// �����Ż��棬��ʱ
    public int countPrimes(int n) {
    	if (n < 3) {
			return 0;
		}
        int count = 1;        
        for(int i = 3;i < n;i++) {
        	boolean flag = true;
        	for(int j = 2;j*j <= i;j++) {
        		if (i % j == 0) {
        			flag = false;
					break;
				}   		
        	}
        	if (flag) {
        		count++;
			}      	
        }
        return count;
    }
    // ��������ɸ��������������O(n)����
    public int countPrimes1(int n) {
    	int count = 0;
    	boolean[] flag = new boolean[n];
    	for(int i = 2;i < n;i++) { 		
    		if (!flag[i]) {
    			count++;
    			for(int j = i+i;j < n;j+=i) {
    				flag[j] = true;
    			}
			}
    	}
    	return count;
    }
}
