package com.zhangxp;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail 和 deleteHead,
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        MyTwoStackQueue twoStackQueue = new MyTwoStackQueue();
        twoStackQueue.appendTail(3);
        twoStackQueue.appendTail(2);
        System.out.println(twoStackQueue.deleteHead());
        System.out.println(twoStackQueue.deleteHead());
        System.out.println(twoStackQueue.deleteHead());
        twoStackQueue.appendTail(4);
        twoStackQueue.appendTail(5);
        System.out.println(twoStackQueue.deleteHead());
        twoStackQueue.appendTail(6);
        System.out.println(twoStackQueue.deleteHead());
        System.out.println(twoStackQueue.deleteHead());
        System.out.println(twoStackQueue.deleteHead());
        System.out.println(twoStackQueue.deleteHead());

    }
}
