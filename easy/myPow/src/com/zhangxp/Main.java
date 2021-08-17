package com.zhangxp;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * 提示：
 * -100.0 < x < 100.0
 * -2的31次方 <= n <= 2的31次方-1
 * -10的4次方 <= x的n次方 <= 10的4次方
 *
 *示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 */
public class Main {
    /**
     * 计算x的n次方
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (x == -1){
            return -1;
        }
        if (n == 0){
            return 1;
        }else if(n>0){
            double sum = 1;
            while (n>0){
                sum *= x;
                n--;
            }
            return sum;
        }else{
            double sum = 1;
            while (n<0){
                sum *= x;
                n++;
            }
            return (double)1/sum;
        }
    }
    public static double myPow2WithRecursion(double x, int n) {
        if (n == 0){
            return 1;
        }
        if (n%2 == 0){
            return n>0?myPow2(x, n/2) * myPow2(x, n/2):
                    1/myPow2(x, n/2) * myPow2(x, n/2);
        }else{
            return n>0?myPow2(x, n/2) * myPow2(x, n/2)*x:
                    1/myPow2(x, n/2) * myPow2(x, n/2)*x;
        }
    }
    public static double myPow2(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        double res = 1.0;
        long b = n;
        if (b<0){
            x = 1/x;
            b = -b;
        }
        while (b>0){
            if (b%2 != 0) {
                res*=x;
            }
            x*=x;
            b=b/2;
        }
        return res;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(myPow2(2,2));



    }
}
