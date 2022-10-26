package com.sqw.linked_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Program: algorithm_exercise
 * @Description: BM5 合并k个已排序的链表
 * @Author: sqw
 * @Create: 2022-10-26
 */
public class Solution5 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int i) {
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) {
            return null;
        }
        List<Integer> newList = new ArrayList<>();

        for (ListNode list : lists) {
            while (list != null) {
                newList.add(list.val);
                list = list.next;
            }
        }
        if(newList.size() == 0) {
            return null;
        }
        // 排序
        Collections.sort(newList);
        ListNode newHead = new ListNode(newList.get(0));
        ListNode cur = newHead;

        for (int i = 1; i < newList.size(); i++) {
            cur.next = new ListNode(newList.get(i));
            cur = cur.next;
        }
        return newHead;
    }
}
