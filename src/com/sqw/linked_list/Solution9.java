package com.sqw.linked_list;

import java.util.List;

/**
 * @Program: algorithm_exercise
 * @Description: BM9 删除链表的倒数第n个节点
 * @Author: sqw
 * @Create: 2022-10-26
 */
public class Solution9 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        if(head == null) {
            return null;
        }
        // 链表长度
        int length = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            length ++;
            tempHead = tempHead.next;
        }
        // 如果n大于链表长度，返回原链表
        if(length < n) {
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = head;
        ListNode pre = res;
        // 记录下标位置
        for (int i = 0; i < length; i++) {
            if(i+n == length) {
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return res.next;
    }
}
