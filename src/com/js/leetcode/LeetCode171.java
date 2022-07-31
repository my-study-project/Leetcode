package com.js.leetcode;

public class LeetCode171 {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String columnTitle) {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number = number + k * multiple;
            multiple *= 26;
        }
        return number;
    }

}
