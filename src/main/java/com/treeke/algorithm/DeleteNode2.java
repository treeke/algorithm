package com.treeke.algorithm;

import java.util.LinkedList;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 */
public class DeleteNode2 {

    public static void main(String[] args) {
        DeleteNode2 deleteNode = new DeleteNode2();
        ListNode listNode = new ListNode(1, new ListNode(2,new ListNode(2, new ListNode(2, new ListNode(5,null)))));
        //ListNode listNode = new ListNode(1, new ListNode(2,new ListNode(3, new ListNode(5, new ListNode(5,null)))));
        //ListNode listNode = new ListNode(1, new ListNode(1,new ListNode(3, new ListNode(5, new ListNode(5,null)))));
        ListNode listNode1 = deleteNode.deleteDuplicates(listNode);
        while (true){
            System.out.println(listNode1.val);
            if(listNode1.next == null){
                break;
            }
            listNode1 = listNode1.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        int delete = Integer.MIN_VALUE;
        ListNode node = head;
        while (node != null){
            int val = node.val;
            if(val == delete){
                node = node.next;
                continue;
            }
            if(!stack.isEmpty()){
                if(stack.peekLast().val == val){
                    stack.pollLast();
                    delete = val;
                    node = node.next;
                    continue;
                }
                if(stack.peekLast().val < val){
                    stack.peekLast().next = node;
                }
            }
            stack.addLast(node);
            node = node.next;
        }
        if(!stack.isEmpty()){
            stack.peekLast().next = null;
        }
        return stack.pollFirst();
    }
}
