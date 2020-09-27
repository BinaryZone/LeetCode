package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode784 {
    public List<String> letterCasePermutation(String S) {
        int letterNum = 0;
        for (char ch : S.toCharArray()) {
            if (Character.isLetter(ch)) {
                letterNum++;
            }
        }
        List<StringBuilder> ans = new ArrayList<>();
        for (int i = 0; i < 1 << letterNum; i++) {
            int b = 0;
            StringBuilder word = new StringBuilder();
            for (char ch : S.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if (((i >> b++) & 1) == 0) {
                        word.append(Character.toLowerCase(ch));
                    } else {
                        word.append(Character.toUpperCase(ch));
                    }
                } else {
                    word.append(ch);
                }
            }
            ans.add(word);
        }
        List<String> fianlAns = new ArrayList<>();
        for (StringBuilder sb : ans) {
            fianlAns.add(sb.toString());
        }
        return fianlAns;
    }
}
