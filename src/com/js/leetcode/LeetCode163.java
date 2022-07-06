package com.js.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode163 {
    public static void main(String[] args) {
        int[] temp = {0, 1, 3, 50, 75};
//        plusOne(temp);
        List<String> missingRanges = findMissingRanges(temp, 0, 99);
        System.out.println(missingRanges);
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // 1ms
        List<String> res = new ArrayList<>();
        long l = lower, u = upper;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - l == 1) {
                res.add(String.valueOf(l));
            } else if (nums[i] - l > 1) {
                res.add(l + "->" + (nums[i] - 1));
            }
            l = (long) nums[i] + 1; // 这步一定需要强制转换,因为num[i]和1都是int型,计算结果也为int型再赋给l,需提前进行类型转换
        }
        if (l == u) {
            res.add(String.valueOf(l));
        } else if (l < u) {
            res.add(l + "->" + u);
        }
        return res;

    }

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        int tempNum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if ((digits[i] + tempNum) % 10 > 0) {
                digits[i] = digits[i] + tempNum - 10;
                tempNum = 1;
            } else {
                digits[i] = digits[i] + tempNum;
                tempNum = 0;
            }
        }
        if (tempNum > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        } else {
            return digits;
        }
    }
}
