package com.zhangxp;

public class Main {
    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int index = 0; index<prices.length; index++) {
            if (prices[index] <= min) {
                min = prices[index];
            }else{
                max = max > (prices[index] - min) ? max:(prices[index] - min) ;
            }
        }
        return max;
    }
    public static void main(String[] args) {
	// write your code here
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
