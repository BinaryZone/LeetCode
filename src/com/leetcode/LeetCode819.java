package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        Set<String> set = new HashSet<>();
        for (String string : banned) {
            set.add(string);
        }
        String ans = "";
        int max = 0;
        Map<String,Integer> map = new HashMap<>();
        StringBuilder word = new StringBuilder();
        char[] para = paragraph.toCharArray();
        for (char ch : para) {
            if (Character.isLetter(ch)) {
                word.append(Character.toLowerCase(ch));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!set.contains(finalword)) {
                    map.put(finalword,map.getOrDefault(finalword,0)+1);
                    if (map.get(finalword) > max) {
                        ans = finalword;
                        max = map.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }
        return ans;
    }
}
