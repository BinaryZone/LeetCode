package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
    	int len = points.length;
    	if (len < 2) {
			return len;
		}
        Arrays.sort(points,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}      	
		});
        int count = 0;
        int[] broad = points[0];
        for(int i = 0;i < len-1;i++) {
        	if (broad[1] >= points[i+1][0]) {
				broad[0] = points[i+1][0];
				if (broad[1] >= points[i+1][1]) {
					broad[1] = points[i+1][1];
				}
			}else {
				count++;
				broad = points[i+1];
			}
        }
        return count+1;
    }
    public static void main(String[] args) {
		int[][] a = {{5,6},{4,5},{3,4},{1,2}};
		Arrays.sort(a,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
        	
		});
		for(int[] link:a) {
			System.out.println(Arrays.toString(link));
		}
	}
}
