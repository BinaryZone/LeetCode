package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode054 {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new LinkedList<>();
        if (matrix.length == 0) {
			return l;
		}
        int r1 = 0;
        int c1 = 0;
        int r2 = matrix.length-1;
        int c2 = matrix[0].length-1;
        while(r1 <= r2 && c1 <= c2) {
        	for(int i = c1;i <= c2;i++) {
        		l.add(matrix[r1][i]);
        	}
        	for(int j = r1+1;j <= r2;j++) {
        		l.add(matrix[j][c2]);
        	}
        	if (r2 -r1 > 0 && c2 - c1 > 0) {
				for(int m = c2-1;m >= c1;m--) {
					l.add(matrix[r2][m]);
				}
				for(int n = r2-1;n >= r1+1;n--) {
					l.add(matrix[n][c1]);
				}
			}
        	r1++;
        	c1++;
        	r2--;
        	c2--;
        }
        return l;
    }
}
