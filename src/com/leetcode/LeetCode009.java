package com.leetcode;

public class LeetCode009 {
	// ת��Ϊ�ַ���
	public boolean isPalindrome(int x) {
        if (x < 0) {
			return false;
		}
        String s = x + "";
        int len = s.length();
        int i = 0;
        for(;i < len/2 && s.charAt(i) == s.charAt(len-i-1);i++) {}
        return i == len/2;
    }
	// ��ת��Ϊ�ַ���
	public boolean isPalindrome1(int x) {
		if (x < 0) {
			return false;
		}
		int pd = 0;
		int pop;
		int temp = x;
		while(temp != 0) {
			pop = temp % 10;
			pd = pd * 10 + pop;
			temp /= 10;
		}
		return pd == x;
	}
	// �Ż����룬ֻ��ת���ֵ�һ��
	public boolean isPalindrome2(int x) {
		if (x < 0 || x%10 == 0 && x != 0) {
			return false;
		}
		int pd = 0;
		while(x > pd) {
			pd = pd* 10 + x%10;
			x /= 10;
		}
		return x == pd || x == pd/10;
	}
}
