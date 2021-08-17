package com.zhangxp;

/** 经典的斐波那契数列
 * 泰波那契序列Tn定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 *
 */
public class Main {
    /**
     *递归解法
     * @param n： 第n个斐波那契数
     */
    public static int tribonacciWithRecursion(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return tribonacciWithRecursion(n-2) + tribonacciWithRecursion(n-1) + tribonacciWithRecursion(n-3);
    }

    /**
     * 非递归解法
     * @param args
     */
    public static int tribonacci(int n) {
        int[] dp = new int[n+3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        if (n<=2) {
            return dp[n];
        }
        int i = 3;
        // dp[n] = dp[n-3] + dp[n-2] + dp[n-1]
        while (i<=n){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            i++;
        }
        return dp[n-3] + dp[n-2] + dp[n-1];
    }
    public static void main(String[] args) {
	// write your code here
//        System.out.println(tribonacciWithRecursion(25));
        System.out.println(tribonacciWithRecursion(25));

    }
}
