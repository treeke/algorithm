package com.treeke.algorithm;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 */
public class DeleteNode {

    public static void main(String[] args) {
        //ListNode listNode = new ListNode(1, new ListNode(2,new ListNode(2, new ListNode(3, new ListNode(5,null)))));
        ListNode listNode = new ListNode(1, new ListNode(1,new ListNode(1, new ListNode(1, new ListNode(1,null)))));
        DeleteNode deleteNode = new DeleteNode();
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
        ListNode node = head;
        if(node != null){
            while (node.next != null){
                if(node.val == node.next.val){
                    node.next = node.next.next;
                    continue;
                }
                node = node.next;
            }
        }
        return head;
    }
}
