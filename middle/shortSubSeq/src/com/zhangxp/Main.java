package com.zhangxp;

/**最短无序连续子数组
 给你一个整数数组nums，你需要找出一个连续子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 请你找出符合题意的最短子数组，并输出它的长度。



 示例 1：
 输入：nums = [2,6,4,8,10,9,15]
 输出：5
 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
nums=[1,3,6,4,5,8,17,18]
 nums[3] < nums[2]
 i = 2;
 j=3;
 示例 2：
 输入：nums = [1,2,3,4]
 输出：0

 示例 3：
 输入：nums = [1]
 输出：0

 nums.length >= 1
 */
public class Main {
    public static int shortSubSeq(int[] nums) {
        int i = 0;
        // 寻找左半部分不用排序的位置
        while((i+1)<nums.length){
            if (nums[i] <= nums[i+1]){
                i++;
            }else{
                break;
            }
        }
        int j = nums.length-1;
        // 判断是否已经到达数组末尾，如果到达末尾，则说明不用排序，直接返回0.
        if (i!=nums.length-1) {
            // 寻找右半部分需要排序的位置。而且由上可知,j>1.
            while (j<i){
                if (nums[j] > nums[j-1]){
                    j--;
                }else{
                    break;
                }
            }
            // 如果右半部分比左半部分小，说明还要将i前移。
            while ((nums[j] < nums[i]) && i!=0){
                i--;
            }
            if (nums[j] > nums[i]){
                return j-i;
            }
            // 如果还是小，需要将j后移。
            while ((nums[j]<nums[i]) && j<nums.length-1){
                j++;
            }
            return j-i+1;
        }else{
            return 0;
        }

    }
    public static void main(String[] args) {
	// write your code here
        int[] nums = {5,3,2};
        System.out.println(shortSubSeq(nums));
    }
}
