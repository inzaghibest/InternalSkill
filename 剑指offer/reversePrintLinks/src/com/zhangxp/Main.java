package com.zhangxp;

import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int[] reversePrint(ListNode head) {
        ListNode pGetLen = head;
        int len = 0;
        // 遍历链表获取链表长度
        while (pGetLen!=null){
            len++;
            pGetLen = pGetLen.next;
        }
        // 用链表长度初始化数组
        int[] prints = new int[len];
        ListNode pGetVal = head;
        // 将链表结点从数组尾部开始放入
        while (pGetVal!=null){
            prints[--len] = pGetVal.val;
            pGetVal = pGetVal.next;
        }
        return prints;
    }
    public int[] reversePrint2(ListNode head) {
        ListNode p = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (p!=null){
            stack.push(p.val);
            p = p.next;
        }
        int size = stack.size();
        int[] prints = new int[size];
        int i = 0;
        while (!stack.empty()) {
            prints[i++] = stack.pop();
        }
        return prints;
    }
    public static void main(String[] args) {
	// write your code here
    }
}
