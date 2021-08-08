package com.zhangxp;

/**
 * 给定整数数组nums和整数 k，请返回数组中第k个最大的元素。
 * 请注意,你需要找的是数组排序后的第 k 个最大的元素，而不是第k个不同的元素。
 */
public class Main {
    // 快速排序的一次划分
    public static int partion(int[] nums, int first, int end) {
        int i = first;
        int j = end;
        while(i < j) {
            while(i<j && nums[i] >= nums[j]) {
                j--;
            }
            if (i<j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            while(i<j && nums[i] >= nums[j]) {
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
    public static int findKthLargest(int[] nums, int k) {
        int end = nums.length - 1;
        int start = 0;
        while (true){
            int index = partion(nums, start, end);
            if ((index+1) == k) {
                return nums[index];
            }else if ((index+1) > k) {
                end = index-1;
            }else{
                start = index+1;
            }
        }
    }
    public static void main(String[] args) {
	// write your code here
        int[] nums = {2,4,8,3,5,6,7,11,9,3};
        System.out.println(findKthLargest(nums, 5));
    }
}
