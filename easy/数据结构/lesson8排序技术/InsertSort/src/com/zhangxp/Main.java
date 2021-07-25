package com.zhangxp;

public class Main {
    public static void straightInsertionSort(int[] nums) {
        // index = 1, 初始有序为数组第一个元素。从第2个元素开始为无序元素，为其寻找插入位置。
        for (int index = 1; index<nums.length; index++) {
            // 需要与前面index-1个元素比较，寻找插入位置
            int location = index - 1;
            // 记录当前值，防止后移时被覆盖
            int temp = nums[index];
            for (location = index - 1; location>=0; location--) {
                if (temp < nums[location]) {
                    // 将元素后移
                    nums[location + 1] = nums[location];
                }else{ // 找到插入位置
                    break;
                }
            }
            // location即为插入的位置
            nums[location+1] = temp;
        }
    }
    public static void shellShort(int[] nums) {
        for (int d = nums.length/2; d>=1; d=d/2) {
            // 以d为增量，对每个子序列进行直接插入排序
            for (int i = d; i<nums.length; i++)
            {
                int temp = nums[i]; // 保存待插入元素
                // 在前面的元素中寻找插入位置
                int loc = i - d;
                for (loc = i - d; loc>=0 && nums[loc] > temp; loc = loc - d) {
                    nums[loc+d] = nums[loc];
                }
                nums[loc+d] = temp;
            }
        }
    }
    public static void main(String[] args) {
	// write your code here
        int nums[] = {12,13,9,20,6,31,24,1,29};
//        straightInsertionSort(nums);
        shellShort(nums);
        for (int i: nums)
        {
            System.out.println(i);
        }
    }
}
