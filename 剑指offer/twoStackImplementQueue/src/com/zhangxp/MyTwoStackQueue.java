package com.zhangxp;

import java.util.Stack;
/**
 *  用两个栈实现队列：实现在队尾添加元素appendTail和从队头取走元素deleteHead.
 * 实现思路：栈的特性：后进先出   队列：先进先出
 * 我们用两个栈一个栈记为tailStack,这个栈的栈顶永远是队尾元素，也就是appendTail是在这个栈push元素
 * 一个栈记为headTail,这个栈的栈顶永远是队头部元素，deleteHead就是对这个栈的pop操作。为此，appendTail和
 * deleteHead的实现如下：
 * appendTail(int val):直接在tailStack中push元素
 * tailStack.push(val);
 * int deleteHead():
 * 这里，我们首先需要判断栈是否为空，如果不为空，则直接进行pop操作，否则，需要将tailStack的全部元素弹出并push入
 * headStack.
 * if(headTail.empty()) {
 *     while(!tailStack.empty()) {
 *         headTail.push(tailStack.pop());
 *     }
 *     return headTail.empty()?-1:headTail.pop();
 * }
 * return headTail.pop();
 * 由此，我们得出用两个栈实现队列的方法
 */

/**
 * @author Administrator
 */
public class MyTwoStackQueue {
    private Stack<Integer> tailStack;
    private Stack<Integer> headStack;
    public MyTwoStackQueue() {
        tailStack = new Stack<Integer>();
        headStack = new Stack<Integer>();
    }

    public MyTwoStackQueue(int initialCapacity) {
        tailStack = new Stack<Integer>();
        headStack = new Stack<Integer>();
    }


    public void appendTail(int val) {
        tailStack.push(val);
    }

    public int deleteHead() {
        if (headStack.empty()) {
            while (!tailStack.empty()){
                headStack.push(tailStack.pop());
            }
            return headStack.empty()?-1:headStack.pop();
        }
        return headStack.pop();
    }
}
