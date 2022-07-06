package com.js.leetcode;

public class LeetCode5 {
    public String longestPalindrome(String s) {
        // 首先长度小于2的直接返回就行了
        if (s == null || s.length() < 1) {
            return "";
        }
        if (s.length() < 2) {
            return s;
        }
        // 定义我们最长的回文子串的开始和结束
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        // 如果左右边界范围内同时左右相等是依次移位
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

}
