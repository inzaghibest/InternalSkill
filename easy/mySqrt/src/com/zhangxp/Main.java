package com.zhangxp;

/**
 * 实现int sqrt(int x)函数。
 * 计算并返回x的平方根，其中x是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 */
public class Main {
    public static int mySqrt(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        // 我们利用折半查找的思想
        int d = n/2;
        while (true){
            if (d*d > n) {
                d=d/2;
            }else if (d*d < n){
                int i = d;
                while (i<=d*2){
                    if (i*i>n){
                        return i-1;
                    }
                    i++;
                }
            }else{
                return d;
            }
        }
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(mySqrt(121));
    }
}
