package com.zhangxp;

import java.util.HashMap;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。
 * 如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class Main {
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i<nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return true;
            }else{
                hashMap.put(nums[i], i);
            }
        }
        return false;
    }
    public static boolean containsDuplicate2(int[] nums) {
        int min = 9999;
        int max = -9999;
        for (int i = 0; i<nums.length; i++){
            if (min > nums[i]){
                min = nums[i];
            }
            if (max < nums[i]){
                max = nums[i];
            }
        }
        if (min<0){
            for (int i =0; i<nums.length; i++){
                nums[i] -= min;
            }
            max -= min;
        }
        int[] tong = new int[max];
        for (int i = 0; i<nums.length; i++){
            tong[nums[i]]+=1;
            if (tong[nums[i]] > 1){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
	// write your code here
        int[] nums = {1};
        System.out.println(containsDuplicate(nums));
    }
}
