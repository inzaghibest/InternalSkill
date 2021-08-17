package com.zhangxp;

import java.util.Stack;

/**
 * @author ：zhangxp
 * @description：TODO
 * @date ：2021/7/26 17:18
 *  * 实现思路：
 *  * 在栈中每push一个元素时，会有一个当前栈的最小值，在栈中每pop一个元素，当前栈的最小值可能会发生成变化。
 *  * 如果在栈push,pop操作时，都能记录下当时栈中元素最小值即可。为此，可以增加一个栈，用来记录当前栈元素的最小值，规则如下：
 *  * 使用两个栈一个栈记录为stackData;另一个栈stackMin用于保存每一步的最小值，
 *  * push操作:
 *  * 当前要压入的值为newNum,stackData正常压入栈，判断stackMin是否为空，
 *  * 如果为空，将newNum压入栈；
 *  * 如果不为空，比较stackMin栈顶元素的大小：newNum>栈顶元素，不做任何操作；
 *  * 如果newNum更小或者等于栈顶元素，将newNum压入栈。
 *  * pop操作：
 *  * stackData弹出元素记为value,比较value和stackMin中栈定元素的大小。按照压入规则，stackMin栈顶记录的是stackData栈的最小值。
 *  * 所以不可能比value大，如果value>栈顶元素，则stackMin不做任何操作。否则，弹出stackMin栈顶元素。
 *  * getMin操作：
 *  * 由上述规则可知， stackMin栈顶是否记录着当前栈的最小值，所以只要获取stackMin的栈顶元素即可。
 */
public class minStackPushQuick implements minStatck {
    // 实际栈元素
    private Stack<Integer> stackData;
    // 用来记录每一步栈的最小值
    private Stack<Integer> stackMin;

    public minStackPushQuick() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }
    @Override
    public void push(int newNum) {
        stackData.push(newNum);
        if (stackMin.empty()){
            stackMin.push(newNum);
        }else{
            if (newNum <= this.stackMin.peek()) {
                stackMin.push(newNum);
            }
        }
    }


    @Override
    public int pop() {
        if (this.stackData.empty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        int val = stackData.pop();
        if (val == this.getMin()) {
            this.stackMin.pop();
        }
        return val;
    }

    @Override
    public int getMin() {
        if (!this.stackMin.empty()) {
            return this.stackMin.peek();
        }
        throw new RuntimeException("Your stack is empty!");
    }

    @Override
    public boolean empty() {
        return stackData.empty();
    }


}
