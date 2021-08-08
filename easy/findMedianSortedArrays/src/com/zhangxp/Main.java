package com.zhangxp;
/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数 。
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
分析：找到两个正序数组的中位数，中位数有两种情况：
 当m+n为奇数时,则中序数应为两个数组合并后下标为(m+n)/2的数
 当m+n为偶数时,则中序数应为两个数组合并后下标为(m+n)/2和(m+n)/2 - 1的两个数之和除以2.
 边界情况:
 当m=n=0时，直接返回0.
 如果(m+n)%2 == 1, 则中位数为(m+n)/2个大的数。
 现在问题关键是如何找到(m+n)/2个的数。
 常规解法：
 边界情况：
 如果两个数组长度均为0，直接返回0.
 否则，设置要寻找的位置为target,则有target = (m+n)/2,设置i = 0, j=0, 为两个数组找寻的初始位置。
 如果有nums1[i] > nums[j], 则j++,target++,否则,i++,直到两个数组寻找到末尾或target = (m+n)/2
 此时判断target是否达到了(m+n)/2,如果没有达到，则说明一个数组找完，则在另一个数组中寻找。如果首个就达到了，
 */

public class Main {
    public static float findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        // 如果两个数组长度均为0,直接返回0.
        if (nums1Len == 0 && nums2Len == 0) {
            return 0;
        }
        // 设置搜寻目标下标
        int target = (nums1Len + nums2Len)/2;
        // nums1搜索的初始位置
        int i = 0;
        // nums2搜索的起始位置
        int j = 0;
        // 搜索到的位置
        int searchLoc = 0;
        // 是否为偶数
        boolean isEven = (nums1Len + nums2Len)%2 == 0;
        if (nums1.length == 0)
        {
            if (isEven){
                return (nums2[target] + nums2[target-1])/2.0f;
            }else{
                return nums2[target];
            }
        }
        int pre = 0;
        while(i<nums1.length && j<nums2.length && searchLoc<target) {
            if (nums1[i] > nums2[j]) {
                    j++;
                    pre = nums2[j];
                }else{
                    pre = nums1[i];
                    i++;
                }
                searchLoc++;
        }
        // 退出循环,看是否找到了searchLoc
        if(searchLoc == target) {
            
        }
        return 1;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(1/2);
    }
}
