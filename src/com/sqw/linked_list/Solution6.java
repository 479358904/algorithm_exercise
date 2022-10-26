package com.sqw.linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * @Program: algorithm_exercise
 * @Description: BM6 判断链表中是否有环
 * @Author: sqw
 * @Create: 2022-10-26
 */
public class Solution6 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode cur = head;

        // 使用Set记录已经访问过的节点
        Set<ListNode> visitedSet = new HashSet<ListNode>();

        while (cur != null) {
            if(visitedSet.contains(cur)) {
                return true;
            }
            visitedSet.add(cur);
            cur = cur.next;
        }
        return false;
    }

}
