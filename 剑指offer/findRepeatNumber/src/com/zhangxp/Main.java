package com.zhangxp;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 限制：
 * 2 <= n <= 100000
 *
 * 题目分析：数组里寻找重复的元素，比较通用的做法是采用Hashmap,将元素值做为key,数组下标做为value存储，如果
 * 遍历数组，hashMap里可以找到相同的key,这key就是重复元素的值。但是本题有个关键点：在长度为n的数组里，所有
 * 的数字都在0~n-1范围内，我们可以怎么利用这一条件呢？
 * 0~n-1刚好是数组的下标，如果我们能够将元素的值存储到其对应下标的地方，也就是说有num[i] = i;我们设置index=0,
 * 如果有nums[index] = index,则继续遍历，index++,否则，我们查看nums[nums[index]] 是否等于index,如果不等，
 * 我们交换这两个元素的位置，
 * 我们看一个例子:
 * nums = {3,4,2,1,1}
 * 第一次比较: nums[index] != index,
 * nums[nums[index]] != nums[index]
 * 1,4,2,3,1
 * nums[index] != 0;
 * nums[nums[index]] != nums[1]
 * 4,1,2,3,1
 * 1,1,2,3,4
 * nums[index] != 0
 * nums[nums[index]] == nums[index]
 * return nums[index]
 * 因为，数组中一定存在重复元素，所以我们一定可以找到。
 * 由此，我们得出写法
 *
 */
public class Main {
    public static int findRepeatNumber(int[] nums) {
        int index = 0;
        while (index<nums.length){
            if (nums[index] != index) {
                // 如果num[index]下标的元素存储的值与下标不一致，则交换两者的位置，否则，说明是重复元素。
                if (nums[index] != nums[nums[index]]){
                    int temp = nums[index];
                    nums[index] = nums[nums[index]];
                    nums[temp] = temp;
                }else{
                    return nums[index];
                }
            }else{
                index++;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
	// write your code here
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 11};
        System.out.println(findRepeatNumber(nums));
    }
}
