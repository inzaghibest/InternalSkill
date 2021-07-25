package com.company;

public class Main {
    public static long pow(int x, int n)
    {
        if (n == 0) {
            return 1;
        }else
        {
            return x*pow(2, n-1);
        }
    }
    public static int reverse(int x) {
        System.out.println(Math.pow(2, 31));
        return 0;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(pow(2,32));
    }
}
