package com.zhangxp;

/**
 * 给定一个个元素有序的（升序）整型数组nums 和一个目标值target，写一个函数搜索nums中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 *二分查找：利用数组是升序的特性，数组中元素的个数为n我们可以进行如下查找。
 * 首先设置index = n/2.如果nums[index] == target,返回index.
 * 如果nums[index] < target, 则target只可能出现在数组的右部。则与右部中间元素继续比较，index=(index+n)/2
 * 如果nums[index] >  target, 则target只可能出现在数组的右部，则与左部中间元素继续比较, index = (index-1)/2
 * 如果index的值<0,或index>=n,则返回false.
 *
 * 我们看一个二分查找的例子
 * nums={1,3,6,9,11,13,16,18,22} n = 9, target = 7
 * index = (0 + 8)/2 = 4;
 * nums[4] = 11 比 7大。
 * index = (0+3)/2 = 1
 * nums[1] = 3, 比7小，
 * 则index = (2+3)/2 = 2
 * nums[2] = 6 比 7小
 * 则indesx = (3 + 3)/2 =3
 * nums[3] = 9 比 7大
 * index = 4
 */
public class Main {
    public static int binarySearch(int[] nums, int left, int right, int target) {
        if (left <= right) {
            int middle = (left + right)/2;
            if (nums[middle] == target) {
                return middle;
            }
            // 在左侧寻找
            if (nums[middle] > target) {
                return binarySearch(nums, 0, middle-1, target);
            }
            return binarySearch(nums, middle+1, right, target);
        }
        return -1;
    }
    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,3,5,6,7,8,9};
        System.out.println(binarySearch(nums, 0, 6, 7));
    }
}
