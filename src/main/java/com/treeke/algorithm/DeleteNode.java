package com.treeke.algorithm;

import java.util.LinkedList;
import java.util.Stack;

public class DeleteNode {

    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
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
