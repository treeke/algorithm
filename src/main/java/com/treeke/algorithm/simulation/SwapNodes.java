package com.treeke.algorithm.simulation;

import com.treeke.algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SwapNodes {

    public ListNode swapNodes(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null){
            list.add(node);
            node = node.next;
        }
        int length = list.size();
        int tmp = list.get(k-1).val;
        list.get(k -1).val = list.get(length - 1 -k).val;
        list.get(length - k).val = tmp;

        return head;
    }
}
