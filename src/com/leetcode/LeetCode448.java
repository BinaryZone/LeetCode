package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            nums[newIndex] = Math.abs(nums[newIndex]) * -1;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        new LeetCode448().findDisappearedNumbers(nums);
    }
}
