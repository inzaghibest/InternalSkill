package com.zhangxp;

import java.util.List;

/**
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 */
public class Main {
     public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 时间复杂度为O(n),空间复杂度为O(1)的算法
     * @param headA A链表头结点
     * @param headB B链表头结点
     * @return 相交的初始结点
     * 思路：如何获得两个链表相交的初始结点。设两个两个链表相交结点前一个A结点为preA,前一个B结点preB,
     * 则有preA.next == preB.next;那么如何找到这个结点呢？从headA和headB依次遍历复杂度为O(n的2次方)。
     * 我们换一个角度来思考这个问题：如果这两个链表相交，则相交之后的结点数目A和B是一样的，那么之前结点数两个链表
     * 可能一样，也可能不一样。如果一样，我们依次从两个链表的初始结点开始比较，如果next不一样，则两个结点分别后移，
     * 直到一样。这样复杂度就为O(n),难点就在于两个链表的长度可能不同.为此，我们分别遍历两个链表的长度，并将较长链表
     * 先移动多出来结点数的位置不就可以了吗。
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode preNodeA = headA;
        ListNode preNodeB = headB;
        // 获取链表A的长度
        int lenA = 0;
        while (preNodeA != null){
            lenA++;
            preNodeA = preNodeA.next;
        }
        // 获取链表B的长度
        int lenB = 0;
        while (preNodeB != null) {
            lenB++;
            preNodeB = preNodeB.next;
        }
        preNodeA = headA;
        preNodeB = headB;
        int dff = 0;
        if (lenA > lenB){
            dff = lenA - lenB;
            // 将A链表前进dff个位置
            while (dff>0){
                preNodeA = preNodeA.next;
                dff--;
            }
        }else if (lenA<lenB){
            dff = lenB - lenA;
            // 将链表B前进dff个位置
            while (dff > 0){
                preNodeB = preNodeB.next;
                dff--;
            }
        }
        while (preNodeA != null && preNodeB != null){
            if (preNodeA == preNodeB){
                return preNodeA;
            }
            preNodeA = preNodeA.next;
            preNodeB = preNodeB.next;
        }
        return null;
    }
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = pA == null? headB:pA.next;
            pB = pB == null? headA:pB.next;
        }
        return pA;
    }
    public static void main(String[] args) {
	// write your code here
    }
}
