package com.js.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode228 {
    public static void main(String[] args) {
        int[] request = {0, 1, 3, 4, 6, 7, 9, 10};
        System.out.println(summaryRanges(request));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            ret.add(temp.toString());
        }
        return ret;
    }

}
