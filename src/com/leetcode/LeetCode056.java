package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode056 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new LinkedList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] temp = new int[2];
            temp[0] = intervals[i][0];
            int max = intervals[i][1];
            while (i+1 < intervals.length && max >= intervals[i+1][0]) {
                if (intervals[i+1][1] > max) {
                    max = intervals[i+1][1];
                }
                i++;
            }
            temp[1] = max;
            list.add(temp);
            i++;
        }
        return list.toArray(new int[0][]);
    }
}
