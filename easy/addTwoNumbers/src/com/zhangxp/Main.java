package com.zhangxp;

/**
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
 * 并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字0之外，这两个数都不会以 0开头。
 */
public class Main {
    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
        {
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode preNode = new ListNode();
        ListNode resultNode = new ListNode();
        int i = 0;
        int carry = 0;
        while(temp1 != null && temp2 != null) {
            int val = 0;
            if (carry > 0) {
                val = temp1.val + temp2.val + 1;
            }else{
                val = temp1.val + temp2.val;
            }
            if (val >= 10) {
                val = val%10;
                carry += 1;
            }else{
                val = val;
                    carry=0;
            }
            ListNode curNode = new ListNode();
            curNode.val = val;
            curNode.next = null;
            if (i == 0) {
                preNode = curNode;
                resultNode = preNode;
            }else{
                preNode.next = curNode;
                preNode = curNode;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
            i++;
        }
        while(temp1 != null) {
            int val = temp1.val;
            if (carry>0) {
                val += 1;
            }else{
                val = val;
            }
            if (val>=10){
                carry++;
                val = 0;
            }else{
                carry = 0;
            }
            ListNode curNode = new ListNode();
            curNode.val = val;
            curNode.next = null;
            preNode.next = curNode;
            preNode = curNode;
            temp1 = temp1.next;
        }
        while(temp2 != null) {
            int val = temp2.val;
            if (carry>0) {
                val += 1;
            }else{
                val = val;
            }
            if (val>=10){
                carry++;
                val = 0;
            }else{
                carry = 0;
            }
            ListNode curNode = new ListNode();
            curNode.val = val;
            curNode.next = null;
            preNode.next = curNode;
            preNode = curNode;
            temp2 = temp2.next;
        }
        if (carry>0) {
            ListNode curNode = new ListNode();
            curNode.val = 1;
            curNode.next = null;
            preNode.next = curNode;
        }
        return resultNode;
    }
    public static void main(String[] args) {
	// write your code here

    }
}
