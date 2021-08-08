package com.zhangxp;

public class Main {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) { // 如果只有一个结点或没有结点直接返回头结点。
            return head;
        }
        ListNode preNode = head; // 标记前一个结点
        ListNode curNode = head.next; // 标记下一个结点
        ListNode resultNode = head;
        while(curNode != null) {
            if (preNode.val == curNode.val) { // 找到重复元素，移除当前节点
                preNode.next = curNode.next;
                curNode = curNode.next;
            }else{ // 移动两个结点
                preNode = preNode.next;
                curNode = curNode.next;
            }
        }
        return head;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode p1 = head;
        while (p1 != null && p1.next != null) {
            if (p1.val == p1.next.val) { // 移除p1.next
                p1.next = p1.next.next;
            }else{
                p1 = p1.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
	// write your code here
    }
}
