package com.treeke.algorithm;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 */
public class FlipLinked {

    public static void main(String[] args) {
        FlipLinked flipLinked = new FlipLinked();
        ListNode listNode = new ListNode(1, new ListNode(2,new ListNode(3, new ListNode(4, new ListNode(5,null)))));
        //ListNode listNode = new ListNode(1, null);
        //ListNode listNode = new ListNode(1, new ListNode(2, null));
        ListNode listNode1 = flipLinked.reverseBetween(listNode, 1, 3);
        while (true){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
            if(listNode1 == null){
                break;
            }
        }
    }

    /**
     * 递归带入翻转起始节点值，删除left节点得next，并递归入下一次方法调用，判断翻转结束补全链接并返回right节点链入left之前
     */
    int index = 1;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        return reversal(head, left, right, null, null);
    }

    public ListNode reversal(ListNode head, int left, int right, ListNode pre, ListNode start){
        ListNode next = head.next;
        if(next == null || index > right){
            if(index == right){
                head.next = pre;
            }
            return head;
        }
        if(index == left){
            index++;
            head.next = null;
            ListNode node = reversal(next, left, right, head, head);
            return node;
        }
        if(index == right){
            head.next = pre;
            index++;
            start.next = reversal(next, left, right, head, null);
            return head;
        }
        if(index > left && index < right){
            head.next = pre;
            index++;
            ListNode node = reversal(next, left, right, head, start);
            return node;
        }else {
            index++;
            head.next = reversal(next, left, right, null, null);
        }
        return head;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
