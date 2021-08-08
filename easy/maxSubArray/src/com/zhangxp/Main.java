package com.zhangxp;

/**
 * 给定一个整数数组nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 */
public class Main {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for(int i = 0; i<nums.length; i++) {
            int total = nums[i];
            if (max < total) {
                max = total;
            }
            for (int j = i+1; j<nums.length; j++) {
                total += nums[j];
                if (max < total) {
                    max = total;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
	// write your code here
        int[] nums = {1};
        System.out.println(maxSubArray(nums));
    }
}
