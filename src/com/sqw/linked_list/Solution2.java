package com.sqw.linked_list;

/**
 * @Program: algorithm_exercise
 * @Description: BM2 链表内指定区间反转
 * @Author: sqw
 * @Create: 2022-05-24
 */
public class Solution2 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int i) {
        }
    }
    /**
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // 加个表头
        ListNode res = new ListNode(0);
        res.next = head;

        // 前序节点
        ListNode pre = res;
        // 当前节点
        ListNode cur = head;
        //找到m
        for(int i = 1;i < m; i++) {
            pre = cur;
            cur = cur.next;
        }

        // 从m反转到n
        for (int i = m; i < n; i++) {
            ListNode  temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        // 返回去掉头节点的链表
        return res.next;
    }
}
