package com.zhangxp;

public class Main {
    public static void simpleSelectionSort(int[] nums) {
        for (int i = 0; i<nums.length - 1; i++) { //
            int index = i;
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            // index为找到的一趟无序区中最小元素的位置，将最小元素放到对应位置。
            if (index != i) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
    }

    // 筛选调整堆的算法, k为要筛选结点, m为最后一个结点。
    public static void sift(int[] nums, int k, int m) {
        // 设置要筛选的结点为i,j为i的左孩子
        int i = k;
        int j = i*2 + 1;
        while(j<=m) {
            if (j<m && nums[j]<nums[j+1]) { // 寻找左右子树的较大者
                j++;
            }
            if (nums[i] > nums[j]) // 如果根结点大于左右孩子的最大者,退出。
            {
                break;
            }else{ // 否则，交换根结点与最大者的位置
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // 被筛选结点的位置变为原来j的位置，继续调整其子树
                i = j;
                j = 2*i;
            }
        }
    }

    public static void heapSort(int[] nums) {
        for (int i = nums.length/2 - 1; i>=0; i--) { // 初始建堆，从最后一个分支结点到根结点
            sift(nums, i, nums.length - 1);
        }
        for (int j = 0; j<nums.length - 1; j++) {
            int temp = nums[0];
            nums[0] = nums[nums.length - 1 -j];
            nums[nums.length - 1 - j] = temp;
            sift(nums,0, nums.length - j - 2);
        }
    }
    public static void main(String[] args) {
	// write your code here
        int[] nums = {49,27,65,97,76,13,38};
//        int[] nums = {10,9,8,7,6,5,4,3,2,1};
//        simpleSelectionSort(nums);
        heapSort(nums);
        for (int i: nums) {
            System.out.println(i);
        }
    }
}
