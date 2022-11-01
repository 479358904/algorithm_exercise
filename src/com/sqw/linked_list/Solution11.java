package com.sqw.linked_list;

import java.math.BigInteger;

/**
 * BM11 链表相加(二)
 */
public class Solution11 {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            val = val;
            next = null;
        }
    }

    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        //任意一个链表为空，返回另一个
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        //反转两个链表
        head1 = reverseList(head1);
        head2 = reverseList(head2);

        //添加表头
        ListNode res = new ListNode(-1);
        ListNode head = res;
        // 进位符号
        int carry = 0;

        while(head1 != null || head2 != null || carry != 0) {
            // 链表不为空取其值
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;

            int temp = val1 + val2 + carry;
            // 开始进位
            carry = temp/10;
            temp = temp % 10;

            head.next = new ListNode(temp);
            head = head.next;

            if (head1 != null )
                head1 = head1 .next;

            if (head2 != null )
                head2 = head2 .next;
        }

        return reverseList(res.next);
    }

    public ListNode reverseList(ListNode pHead){
        if(pHead == null) {
            return null;
        }
        ListNode cur = pHead;
        ListNode pre = null;

        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
