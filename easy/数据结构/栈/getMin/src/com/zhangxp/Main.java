package com.zhangxp;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 要求：
 * 1.pop,push,getMin操作的时间复杂度都是O(1).
 * 2.设计的栈类型可以使用现成的栈结构。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        minStatck myStack = new minStackPushQuick();
        myStack.push(3);
        myStack.push(4);
        myStack.push(2);
        myStack.push(7);
        myStack.push(1);
        while (!myStack.empty()) {
            System.out.println("----pop:----" + myStack.pop());
            System.out.println("----getMin:----"+myStack.getMin());
        }
    }
}
