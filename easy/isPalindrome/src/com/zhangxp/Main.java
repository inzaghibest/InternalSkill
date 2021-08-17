package com.zhangxp;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 给你一个整数 x ，如果x是一个回文整数，返回true；否则，返回false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121是回文，而123不是。
 *示例 1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 示例 4：
 * 输入：x = -101
 * 输出：false
 *
 */
public class Main {
    /**
     * 判断一个整数是否为回文数
     * @param x 整数
     * @return 是回文数返回true,不是回文数返回false.
     * 按照规则，负数一定不是回文数。
     * 所以我们考虑正整数的情况：
     * 依次获取正整数的每一位，然后正序，反序存储。依次比较每一位，如果比较完毕，每一位都相等则为回文数。
     * 否则，不是回文数。
     */
    public static boolean isPalindrome(int x) {
        // 负数不是回文数
        if (x<0) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Integer> queue = new ConcurrentLinkedDeque<Integer>();
        while(x>0){
            int val = x%10;
            stack.push(val);
            queue.add(val);
            x = x/10;
        }
        while (!stack.isEmpty()&&!queue.isEmpty()){
            if (stack.pop() != queue.poll()) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome2(int x) {
        // 负数不是回文数
        if (x<0) {
            return false;
        }
        int[] numsPositive = new int[10];
        int i = 0;
        int k = x;
        while(k>0){
            int val = k%10;
            numsPositive[i++] = val;
            k = k/10;
        }
        int j = 0;
        while (i >= j && x!=0){
            if (numsPositive[--i] != numsPositive[j++]){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome3(int x) {
        // 负数不是回文数
        if (x<0) {
            return false;
        }
        long ans = 0;
        int temp = x;
        while (temp > 0) {
            ans = ans*10 + temp%10;
            temp /= 10;
        }
        return x == ans;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(isPalindrome3(121));
    }
}
