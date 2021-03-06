package com.company;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，
 * 返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 */
public class Main {
    public static int searchInsert(int[] nums, int target) {
        for(int index = 0; index < nums.length; index++)
        {
            if(target <= nums[index] )
            {
                return index;
            }
        }
        return nums.length;
    }
    public static int searchInsertByBinary(int[] nums, int left, int right, int target) {
        int middle = (left + right)/2;
        if (target > nums[middle])
        {
            if ((middle+1) >= right)
            {
                return middle+1;
            }
            return searchInsertByBinary(nums, middle+1, right, target);
        }else if (target == nums[middle])
        {
            return middle;
        }else
        {
            if (middle - 1 <= 0)
            {
                return middle;
            }
            return searchInsertByBinary(nums, left, middle-1, target);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,8,11};
        System.out.println(searchInsert(nums, 9));
        System.out.println(searchInsertByBinary(nums, 0, nums.length-1, 7));
    }
}
