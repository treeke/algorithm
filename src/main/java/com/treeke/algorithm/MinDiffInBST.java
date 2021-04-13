package com.treeke.algorithm;

import java.util.*;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 */
public class MinDiffInBST {

    public static void main(String[] args) {

    }

    List<Integer> list = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        add(root);
        Collections.sort(list);
        Integer res = null;
        for (int i = 0; i < list.size()-1; i++) {
            Integer left = list.get(i);
            Integer rifht = list.get(i+1);
            if(rifht == left){
                continue;
            }
            int calc = rifht - left;
            res = res == null ? calc : Math.min(res, calc);
        }
        return res;
    }

    private void add(TreeNode root) {
        int val = root.val;
        list.add(val);
        if(root.left != null){
            add(root.left);
        }
        if(root.right != null){
            add(root.right);
        }
    }
}
