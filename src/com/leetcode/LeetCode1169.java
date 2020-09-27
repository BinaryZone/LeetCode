package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode1169 {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new LinkedList<>();
        int i = 0;
        while (i < transactions.length) {
            String transaction = transactions[i];
            if (Integer.getInteger(splitTrans(transaction,2)) > 1000) {
                ans.add(transaction);
            }
        }
        return ans;
    }
    private String splitTrans(String transaction,int a) {
        String[] split;
        split = transaction.split(",");
        return split[a];
    }
}
