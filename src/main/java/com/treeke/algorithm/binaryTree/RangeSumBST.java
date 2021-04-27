package com.treeke.algorithm.binaryTree;

import com.treeke.algorithm.TreeNode;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class RangeSumBST {

    int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        ans(root, low, high);
        return sum;
    }

    public void ans(TreeNode root, int low, int high){
        if(root == null){
            return;
        }
        ans(root.left, low, high);
        int val = root.val;
        if(val >= low && val <= high){
            sum += val;
        }
        ans(root.right, low, high);
    }
}
