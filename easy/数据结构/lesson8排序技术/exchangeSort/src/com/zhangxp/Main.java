package com.zhangxp;

public class Main {
    public static void bubbleSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
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
    public static void quickSort(int[] nums, int first, int end) {
        if (first < end) {
            int pivot = partion(nums, first, end); // 一次划分
            quickSort(nums, first, pivot-1); // 递归地对左侧子序列进行快速排序
            quickSort(nums,pivot+1,end); // 递归地对右侧子序列进行快速排序
        }
    }
    public static void main(String[] args) {
	// write your code here
       // int[] nums = {0,13,1,9,14,16,81,22,5,2};
        int[] nums = {13,5,9,8,2,1,15,66,12,9,9,81};
        quickSort(nums, 0, nums.length - 1);

//        bubbleSort(nums);
        for (int i: nums) {
            System.out.println(i);
        }
    }
}
