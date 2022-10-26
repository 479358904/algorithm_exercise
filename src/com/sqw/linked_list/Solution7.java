package com.sqw.linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * @Program: algorithm_exercise
 * @Description: BM7 链表中环的入口结点
 * @Author: sqw
 * @Create: 2022-10-26
 */
public class Solution7 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode cur = pHead;

        // 使用Set记录已经访问过的节点
        Set<ListNode> visitedSet = new HashSet<ListNode>();

        while (cur != null) {
            if(visitedSet.contains(cur)) {
                return cur;
            }
            visitedSet.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
