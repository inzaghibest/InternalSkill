package com.zhangxp;

public class Main {
    /**
     * 一次归并的实现
     * @param r 要排序的数组
     * @param r1 归并后存入元素的数组
     * @param s 归并左序列的起始下标
     * @param m 归并左序列的结束下标
     * @param t 归并右序列的结束下标
     */
    public static void merge(int[] r, int[] r1, int s, int m, int t) {
        int i = s;
        int j = m+1;
        int k = s;
        while(i<=m && j<=t)
        {
            if (r[i] <= r[j])
            {
                r1[k++] = r[i++];
            }else{
                r1[k++] = r[j++];
            }
        }
        if (i<=m){
            while(i<=m) {
                r1[k++] = r[i++];
            }
        }else{
            while(j<=t) {
                r1[k++] = r[j++];
            }
        }
    }

    /**
     * 一趟归并算法实现
     * @param r 待归并排序的数组序列
     * @param r1 归并后存储结果的序列
     * @param n 待归并序列的长度
     * @param h 归并的步长(每个有序数组的个数)
     */
    public static void mergePass(int[] r, int[] r1, int n, int h) {
        int i = 0;
        while (i<=n-2*h) { // 待归并记录至少有两个长度为h的序列
            merge(r, r1, i, i+h-1, i+2*h-1);
            i+=2*h;
        }
        if (i<n-h) { // 待归并序列有一个小于h
            merge(r, r1, i, i+h-1, n-1);
        }else{
            for (int k = i; k<n; k++) { // 待归并序列中只剩一个子序列
                r1[k] = r[k];
            }
        }
    }

    /**
     * 归并排序
     * @param r 要排序数组
     * @param r1 容纳归并结果的数组
     * @param n 数组长度
     */
    public static void mergeSortNoRecursion(int[] r, int[] r1, int n) {
        int h = 1;
        // 注：如果排序趟数为奇数，则最终结果在r1里。所以我们这里执行偶数次mergePass.因为如果有h = 2*h > n的情况
        // 出现,执行mergePass就是将r和r1交换。
        while(h<n) {
            mergePass(r, r1, n, h);
            h = 2*h;
            mergePass(r1, r, n, h);
            h = 2*h;
        }
    }

    /**
     *
     * @param args
     */
    public static void mergeSortRecursion(int[] r, int[] r1, int s, int t) {
        if (s == t) {
            r1[s] = r[s];
        }else{
            int m = (s+t)/2;
            mergeSortRecursion(r, r1, s, m);
            mergeSortRecursion(r, r1, m+1, t);
            merge(r1, r, s, m, t);
        }
    }
    public static void main(String[] args) {
	// write your code here
        int[] nums = {13,22,4,9,6,7,11,10,45,31,27,19,33,20,17};
        int[] nums1 = new int[15];
//        mergeSortNoRecursion(nums, nums1, 15);
        mergeSortRecursion(nums, nums1, 0, 14);
        for (int i: nums1) {
            System.out.println(i);
        }
    }
}
