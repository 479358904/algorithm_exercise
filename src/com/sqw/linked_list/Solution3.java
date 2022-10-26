package com.sqw.linked_list;

/**
 * @Program: algorithm_exercise
 * @Description: BM3 链表中的节点每k个一组翻转
 * @Author: sqw
 * @Create: 2022-10-26
 */
public class Solution3 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int i) {
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        // 插入头节点
        ListNode res = new ListNode(0);
        res.next = head;
        // 前序节点
        ListNode pre = res;
        // 当前节点
        ListNode cur = head;
        // 链表长度
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        for (int i = 0; i < length / k; i++) {

            for (int j = 0; j < k-1; j++) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return res.next;
    }
}
