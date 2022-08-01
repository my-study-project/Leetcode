package com.js.leetcode;

import com.js.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode144 {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        preorderTraversalResult(root, result);
        return result;
    }

    public void preorderTraversalResult(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversalResult(root.left, result);
        preorderTraversalResult(root.right, result);

    }
}
