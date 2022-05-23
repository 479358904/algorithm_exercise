package com.sqw.linked_list;

import java.util.Stack;

/**
 * @Program: my_algorithm_exercise
 * @Description: 反转链表解决方案
 * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
 *
 * 数据范围： 0\leq n\leq10000≤n≤1000
 * 要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。
 *
 * 如当输入链表{1,2,3}时，
 * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
 * @Author: sqw
 * @Create: 2022-05-19
 */
public class ReverseListSolution {


    /**
     * 链表节点类
     */
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 通过进栈出栈来反转链表
     */
    public ListNode solutionOfStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        //把链表所有元素进栈
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        //判断是不是空链表
        if (stack.isEmpty())
            return null;

        //开始出栈
        //newHead为新的表头
        ListNode node = stack.pop();
        ListNode newHead = node;

        //每次出栈后再判断一次栈里是否还有元素，还有就继续出栈
        while (!stack.isEmpty()) {
            //反转链表节点的next
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = tempNode;
        }

        //链表尾节点的next置为null
        node.next = null;
        return newHead;
    }

    /**
     * 双链表求解是把原链表的结点一个个摘掉，每次摘掉的链表都让他成为新的链表的头结点，然后更新新链表。下面以链表1→2→3→4为例画个图来看下。
     */
    public ListNode solutionOfHead(ListNode head) {
        //新链表
        ListNode newHead = null;

        while ( head != null ) {
            //首先访问第一个节点，保存起来，留给下一步访问
            ListNode tempNode = head.next;
            //每次访问的原链表节点都会成为新链表的头结点，其实就是把新链表挂到访问的原链表节点的后面就行了
            head.next = newHead;
            //更新新链表
            newHead = head;
            //重新赋值，继续访问
            head = tempNode;
        }
        return newHead;
    }

    /**
     * 递归，简洁明了，但是一定要对函数有正确理解
     */
    public ListNode solutionOfReverse(ListNode head) {
        //终止条件，空链表或者只有一个节点的链表
        if(head == null || head.next == null) {
            return head;
        }
        //相当于去除头节点，将子链表反转
        ListNode newListNode = solutionOfReverse(head.next);
        //子链表反转后，处理头结点
        //head.next指向的是子链表反转后的为尾结点，子链表的尾结点的next再指向head，此时head变成尾结点
        head.next.next = head;
        //head变成尾结点后，head.next需要变为null
        head.next = null;
        return newListNode;
    }

    public static void main(String[] args) {
        System.out.printf("LLLLLLLL");
    }
}