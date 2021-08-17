package com.zhangxp;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Main {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            // 标记当前结点的下一个结点
            ListNode next = cur.next;
            // 当前结点的next指向前一个结点
            cur.next = pre;
            // 前一个结点后移
            pre = cur;
            // 当前结点后移
            cur = next;
        }
        return pre;
    }

    public static ListNode reverseListWithRecursion(ListNode head) {
        // 如果当前结点为null
        if (head == null||head.next == null) {
            return head;
        }
        // 反转下一个结点后得到了反转后的头结点
        ListNode last = reverseListWithRecursion(head.next);
        // 该头结点的下一个结点应该指向前一个结点
        head.next.next = head;
        // 将前一个结点的next置位null
        head.next = null;
        // 返回头结点
        return last;
    }
    public static void main(String[] args) {
	// write your code here
    }
}
