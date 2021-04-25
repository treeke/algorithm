package com.treeke.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 */
public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        getTreeNode(root, list);

        TreeNode res = new TreeNode(-1);
        for (TreeNode node : list){
            res.right = node;
            res = node;
        }
        return list.isEmpty() ? null : list.get(0);

    }

    private void getTreeNode(TreeNode root, List<TreeNode> list) {
        if(root == null){
            return;
        }
        getTreeNode(root.left, list);
        list.add(root);
        getTreeNode(root.right, list);
        root.left = root.right = null;
    }
}
