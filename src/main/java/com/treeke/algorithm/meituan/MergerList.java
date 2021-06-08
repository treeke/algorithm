package com.treeke.algorithm.meituan;

import com.treeke.algorithm.ListNode;

public class MergerList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0, new ListNode(1, new ListNode(5)));
        ListNode listNode2 = new ListNode(2, new ListNode(3, new ListNode(4)));
        ListNode merge = merge1(listNode1, listNode2);
        while (merge != null){
            System.out.println(merge.val);
            merge = merge.next;
        }
    }

    public static ListNode merge2(ListNode node1, ListNode node2){
        ListNode listNode = node1.val > node2.val ? node2 : node1;


        return listNode;
    }


    /**
     * 判断当前node1和node2状态
     * 选择大小插入新链表
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode merge1(ListNode node1, ListNode node2){
        ListNode res = new ListNode(0);
        ListNode listNode = res;
        while (true){
            if(node1 != null && node2 != null){
                if(node1.val >= node2.val){
                    listNode.next = node2;
                    node2 = node2.next;
                }else {
                    listNode.next = node1;
                    node1 = node1.next;
                }
            }else if(node1 == null && node2 != null){
                listNode.next = node2;
                node2 = node2.next;
            }else if(node1 != null && node2 == null){
                listNode.next = node1;
                node1 = node1.next;
            }else {
                break;
            }
            listNode = listNode.next;
        }
        return res.next;
    }
}
