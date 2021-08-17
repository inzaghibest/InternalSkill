package com.zhangxp;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 示例2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 提示：
 * 0 <= nums.length <= 105
 * -109<= nums[i]<= 109
 * nums是一个非递减数组
 * -109<= target<= 109
 *
 */
public class Main {
    /**
     * 利用数组有序的特性，我们立即可以想到二分查找。由于是要统计重复数字出现的次数，在找到元素后，我们还要向
     * 前和向后遍历，找到重复的次数。
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length-1;
        while (low<=high) {
            int mid = low + ((high-low)>>1);
            if (nums[mid] > target) {
                high = mid - 1;
            }else if (nums[mid] < target){
                low = mid + 1;
            }else{
                int count = 1;
                int k = mid;
                while (k>0){
                    if (nums[--k] != target){
                        break;
                    }
                    count++;
                }
                while (mid<nums.length-1){
                    if (nums[++mid] !=  target){
                        break;
                    }
                    count++;
                }
                return count;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
	// write your code here
        int[] nums = {};
        System.out.println(search(nums, 5));
    }
}
