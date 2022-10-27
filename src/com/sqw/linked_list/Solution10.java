package com.sqw.linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * @Program: algorithm_exercise
 * @Description: BM10 两个链表的第一个公共结点
 * @Author: sqw
 * @Create: 2022-10-26
 */
public class Solution10 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) {
            return null;
        }
        // 使用Set记录已经访问过的节点
        Set<ListNode> visitedSet = new HashSet<ListNode>();
        while (pHead1 != null) {
            visitedSet.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if(visitedSet.contains(pHead2)) {
                return pHead2;
            }
            visitedSet.add(pHead2);
            pHead2 = pHead2.next;
        }
        return null;
    }
}
