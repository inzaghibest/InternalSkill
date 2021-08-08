package com.zhangxp;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Main {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // write your code here
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode pNode = head;
        while(pNode != null) {
            len += 1;
            pNode = pNode.next;
        }
        len = len - n + 1;
        int index = 1;
        pNode = head;
        while(index < len-1) {
            pNode = pNode.next;
        }

    }
    public static void main(String[] args) {
	// write your code here
        public ListNode removeNthFromEnd(ListNode head, ) {

        }
    }
}
