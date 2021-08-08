package com.zhangxp;

/**
 * 给你两个有序整数数组nums1和nums2,请你将nums2合并到nums1中，使nums1成为一个有序数组。
 *
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1的空间大小等于m + n，
 * 这样它就有足够的空间保存来自 nums2 的元素。
 * 解决问题的关键点1:如何将nums2的元素放入nums1?
 * 问题关键点2：如何判断nums2的所有元素都放入了nums1?
 * 下面看一个合并的例子:
 * nums1 = [1,3,5,7,0,0,0,0]
 * nums2 = [1,2,6,8]
 * nums2第一个元素放入nums1
 * nums1 = [1,1,3,5,7,0,0,0]
 * 问题1的解决,设置指针j = 0,指向nums2的初始元素。设置指针i = 0,指向nums1的初始元素。
 * 如果nums[i]>=nums[j],则将i++,否则，将nums[j]放入nums[i],
 * 此时需要后移nums[i]元素。而如何判断后移元素的结束呢？每放入一个nums2元素,nums1元素的个数就变为了m+j+1(注意j为下标，
 * 从0开始).所以需要移动到nums1[m+j].算法如下:
 * int i = 0;
 * int j = 0;
 * int end = m;
 * while(i<end && j<m) {
 *     if(nums1[i] >= nums2[j]) {
 *         i++;
 *     }else{
 *         int temp = nums[i];
 *         nums1[i] = nums2[j];
 *         end++;
 *         for(int k = i+1; k<end; k++) {
 *             int nums = nums1[k];
 *             nums1[k] = temp;
 *             temp = nums;
 *         }
 *         i++;
 *         j++;
 *     }
 * }
 * // 退出循环时，有如下情况：
 * i>=end且j<n,这种情况说明：nums1中所有元素均已和nums2的元素比较完毕,但是nums2的元素都已比nums1中的元素大。
 * i>=end且j>=n,这种情况说明：nums2中元素均已放入nums1.
 * i<=end 且 j>=n :不成立。
 * 所以只需判断情况1
 * if(j<n) {
 *     for(int j; j<n; j++) {
 *         nums1[i++] = nums2[j];
 *     }
 * }
 */
public class Main {
    /**
     * 合并两个有序数组
     * @param nums1 容纳合并元素的数组也是数组nums1
     * @param m nums1初始元素个数m
     * @param nums2 nums2有序数组
     * @param n nums2的数组个数
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
          int i = 0;
          int j = 0;
          int end = m; // 记录当前nums1中元素的个数
          while(i<end && j<n) {
              if(nums1[i] < nums2[j]) {
                  i++;
              }else{
                  int temp = nums1[i];
                  nums1[i] = nums2[j]; // 将nums2[j]放入nums1.
                  end++;
                  for(int k = i+1; k<end; k++) { // 后移nums[i+1]之后的元素
                      int nums = nums1[k];
                      nums1[k] = temp;
                      temp = nums;
                  }
                  i++;
                  j++;
              }
         }
         // 只有这一种情况
         while(j<n) {
             nums1[i++] = nums2[j++];
         }
    }
    public static void main(String[] args) {
	// write your code here
        int[] nums1 = {1};
        int[] nums2 = {};
        merge(nums1, 1, nums2, 0);
        for (int i:nums1) {
            System.out.println(i);
        }
    }
}
