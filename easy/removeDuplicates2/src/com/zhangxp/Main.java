package com.zhangxp;

/**
 * 给你一个有序数组nums ，请你原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。
 * 不需要考虑数组中超出新长度后面的元素。
 */
public class Main {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        int newLen = nums.length;
        while(i<newLen && j<newLen) {
            // 移除元素nums[j]
            if (nums[i] == nums[j]){
                for (int index = j+1; index<newLen; index++) {
                    nums[index-1] = nums[index];
                }
                newLen--;
            }else{
                i++;
                j++;
            }
        }
        return newLen;
    }
    public static void main(String[] args) {
	// write your code here
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        for (int i: nums) {
            System.out.println(i);
        }
    }
}
