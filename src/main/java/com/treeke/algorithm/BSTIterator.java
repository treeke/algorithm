package com.treeke.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 *
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 */
public class BSTIterator {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BSTIterator bstIterator = new BSTIterator(root);
        while (bstIterator.hasNext()){
            System.out.println(bstIterator.next());
        }
    }
    List<Integer> list = null;
    int index = -1;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        bst(root);
    }

    public void bst(TreeNode node){
        if(node.left != null){
            bst(node.left);
        }
        list.add(node.val);
        if(node.right != null){
            bst(node.right);
        }
    }

    public int next() {
        index++;
        return list.get(index);
    }

    public boolean hasNext() {
        return index + 1 < list.size();
    }
}
