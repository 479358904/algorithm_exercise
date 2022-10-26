package com.sqw.linked_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Program: algorithm_exercise
 * @Description: BM4 合并两个排序的链表
 * @Author: sqw
 * @Create: 2022-10-26
 */
public class Solution4 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int i) {
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        if(list1 == null && list2 == null) {
            return null;
        }
        List<Integer> newList = new ArrayList<>();
        while(list1 != null ) {
            newList.add(list1.val);
            list1 = list1.next;
        }

        while(list2 != null ) {
            newList.add(list2.val);
            list2 = list2.next;
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
