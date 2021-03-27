package com.treeke.algorithm;

import java.util.Stack;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
public class RotateNode {

    public static void main(String[] args) {
        RotateNode rotateNode = new RotateNode();
        //ListNode listNode = new ListNode(0, new ListNode(1, new ListNode(2, null)));
        //ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5,null)))));
        ListNode listNode = new ListNode(1, null);
        ListNode list = rotateNode.rotateRight(null, 2);
        while (list != null){
            System.out.println(list.val);
            list = list.next;
        }
    }


    public ListNode rotateRight(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node != null){
            stack.push(node);
            node = node.next;
        }
        int i = 0;
        if(stack.size() != 0 && (i = k % stack.size()) != 0) {
            stack.peek().next = head;
            for (int j = i; j > 0; j--) {
                ListNode pop = stack.pop();
                if(j == 1){
                    stack.peek().next = null;
                    return pop;
                }
            }
        }
        return head;
    }
}
