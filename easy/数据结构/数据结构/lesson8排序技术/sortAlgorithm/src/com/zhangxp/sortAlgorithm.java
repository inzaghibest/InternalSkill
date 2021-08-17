package com.zhangxp;

/**
 * @author ：zhangxp
 * @description：排序算法合集
 * @date ：2021/8/11 14:01
 */
public class sortAlgorithm {
    /**
     * 交换两个数的值
     * @param a 待交换数a
     * @param b 待交换数b
     */
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    /**
     * 插入排序
     * @param nums 待排序数组
     */
    public static void insertSort(int[] nums) {
        // 将nums[0]看做初始有序序列，对nums[1]~nums[n-1]元素进行插入有序序列。
        for (int i = 1; i<nums.length; i++){
            // 在有序序列0~i-1中寻找插入位置
            int j = 0;
            int temp = nums[i];
            for (j = i-1; j>=0; j--) {
                // 元素后移
                if (temp < nums[j]){
                    nums[j+1] = nums[j];
                }else{ // 找到插入位置
                    break;
                }
            }
            // 元素插入位置
            nums[j+1] = temp;
        }
    }

    /**
     * 希尔排序
     * @param nums 待排序数组
     */
    public static void shellSort(int[] nums) {
        for (int d = nums.length/2; d>=1; d=d/2) {
            // 以d为增量，对每个子序进行直接插入排序
            for (int i = d; i<nums.length; i++){
                int temp = nums[i];
                int loc = i-d;
                for (loc = i-d; loc>=0 && nums[loc] > temp; loc = loc-d) {
                    nums[loc+d] = nums[loc];
                }
                nums[loc+d] =  temp;
            }
        }
    }

    /**
     * 起泡排序：交换排序
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        int exchange = nums.length - 1;
        while (exchange > 0 ) {
            int bound = exchange;
            exchange = 0;
            for (int j = 0; j<bound; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    exchange = j;
                }
            }
        }
    }
    // 快速排序的一次划分
    public static int partion(int[] nums, int first, int end) {
        int i = first;
        int j = end;
        while(i < j) {  // 右侧扫描
            while(i<j && nums[i] <= nums[j]) {
                j--;
            }
            if (i<j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            while(i<j && nums[i] <= nums[j]) {
                i++;
            }
            if (i<j)
            {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
            }
        }
        return i;
    }

    /**
     * 快速排序
     * @param nums 待排序数组
     * @param first 数组的起始下标
     * @param end 数组的结束下标
     */
    public static void quickSort(int[] nums, int first, int end) {
        if (first < end) {
            int pivot = partion(nums, first, end); // 一次划分
            quickSort(nums, first, pivot-1); // 递归地对左侧子序列进行快速排序
            quickSort(nums,pivot+1,end); // 递归地对右侧子序列进行快速排序
        }
    }

    /**
     * 简单选择排序
     * @param nums 待排序数组
     */
    public static void simpleSelectionSort(int[] nums) {
        for (int i = 0; i<nums.length - 1; i++) { //
            int index = i;
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            // index为找到的一趟无序区中最小元素的位置，将最小元素放到对应位置。
            if (index != i) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
    }
    // 筛选调整堆的算法, k为要筛选结点, m为最后一个结点。
    public static void sift(int[] nums, int k, int m) {
        // 设置要筛选的结点为i,j为i的左孩子
        int i = k;
        int j = i*2 + 1;
        while(j<=m) {
            if (j<m && nums[j]<nums[j+1]) { // 寻找左右子树的较大者
                j++;
            }
            if (nums[i] > nums[j]) // 如果根结点大于左右孩子的最大者,退出。
            {
                break;
            }else{ // 否则，交换根结点与最大者的位置
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // 被筛选结点的位置变为原来j的位置，继续调整其子树
                i = j;
                j = 2*i;
            }
        }
    }

    /**
     * 堆排序
     * @param nums 待排序数组
     */
    public static void heapSort(int[] nums) {
        for (int i = nums.length/2 - 1; i>=0; i--) { // 初始建堆，从最后一个分支结点到根结点
            sift(nums, i, nums.length - 1);
        }
        for (int j = 0; j<nums.length - 1; j++) {
            int temp = nums[0];
            nums[0] = nums[nums.length - 1 -j];
            nums[nums.length - 1 - j] = temp;
            sift(nums,0, nums.length - j - 2);
        }
    }
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


}
