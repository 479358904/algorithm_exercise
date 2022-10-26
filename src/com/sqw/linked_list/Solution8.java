package com.sqw.linked_list;

/**
 * @Program: algorithm_exercise
 * @Description: BM8 链表中倒数最后k个结点
 * @Author: sqw
 * @Create: 2022-10-26
 */
public class Solution8 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // 链表长度
        int length = 0;
        ListNode temp = pHead;
        while (temp != null) {
            length ++;
            temp = temp.next;
        }
        // 判断极端情况
         if(k == 0 || k > length || pHead == null) {
             return null;
         }
          ListNode cur = pHead;
         // 记录下标位置
        for (int i = 0; i < length; i++) {
            if(i+k == length) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Solution8 s8 = new Solution8();
        s8.FindKthToTail(l1,2);
    }

}
