package com.zhangxp;

import java.util.HashMap;
import java.util.LinkedHashMap;

/** 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * // 进阶
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class Main {
    public static int singleNumberWithHash(int[] nums) {
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i<nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.remove(nums[i]);
            }else{
                hashMap.put(nums[i], i);
            }
        }
        for (int i = 0; i<nums.length; i++){
            if (hashMap.containsKey(nums[i])){
                return hashMap.get(nums[i]);
            }
        }
        return -1;
    }
    public static int singleNumberWithXOR(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,2,1,2,4,3,3};
        System.out.println(singleNumberWithXOR(nums));
    }
}
