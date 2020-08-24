package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R*C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans[i*C+j][0] = i;
                ans[i*C+j][1] = j;
            }
        }
        Arrays.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return manhadun(o1,r0,c0) - manhadun(o2,r0,c0);
            }
        });
        return ans;
    }
    private int manhadun(int[] l1, int r0, int c0) {
        return Math.abs(l1[0] - r0) + Math.abs(l1[1] - c0);
    }
}
