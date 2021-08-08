package com.zhangxp;

import java.util.List;

public class Main {
      public static class ListNode {
          int val;
          ListNode next;

          ListNode() {
          }

          ListNode(int val) {
              this.val = val;
          }

          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param l1 链表1头结点
     * @param l2 链表2头结点
     * @return 拼接后链表头结点
     */
      public static ListNode mergeTwoLists(ListNode l1,ListNode l2) {
          if (l1 == null) {
              return l2;
          }
          if (l2 == null) {
              return l1;
          }
          // 记录返回的头结点
          ListNode headNode = new ListNode();
          // 标识前一个结点
          ListNode preNode = new ListNode();
          ListNode l1Node = l1;
          ListNode l2Node = l2;
          boolean first = true;
          boolean isL1 = false;
          while(l1Node!=null && l2Node!=null) {
            if (first) { // 构造头结点
                if (l1Node.val > l2Node.val) {
                    headNode = l2Node;
                    preNode = l2Node;
                    l2Node = l2Node.next;
                }else{
                    headNode = l1Node;
                    preNode = l1Node;
                    l1Node = l1Node.next;
                    isL1 = true;
                }
                first = false;
                continue;
            }
            if (l1Node.val > l2Node.val) { // 应该指向l2结点
                if (!isL1) { // 上次在l2,则不用做什么
                    preNode = l2Node;
                    l2Node = l2Node.next;
                }else{ // 说明上次的结点在l1,需要拆链
                    preNode.next = l2Node;
                    preNode = l2Node;
                    l2Node = l2Node.next;
                    isL1 = false;
                }
            }else{ // 应该指向l1结点
                if (isL1) { //不用做什么
                    preNode = l1Node;
                    l1Node = l1Node.next;
                }else{ // 说明上次在l1结点，需要拆链
                    preNode.next = l1Node;
                    preNode = l1Node;
                    l1Node = l1Node.next;
                    isL1 = true;
                }
            }
          }
          if (l1Node == null) {
              preNode.next = l2Node;
          }else{
              preNode.next = l1Node;
          }
          return headNode;
      }

    public static void main(String[] args) {
	// write your code here
    }
}
