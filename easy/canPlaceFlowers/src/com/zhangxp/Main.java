package com.zhangxp;

public class Main {
    public static boolean locCanPlaceFlower(int[] nums, int index) {
        if (nums[index] == 0){
            
        }
        if (index == nums.length - 1) {
           return nums[index-1] == 0;
        }
        return nums[index-1] == 0 && nums[index+1] == 0;
    }
    public static void main(String[] args) {
	// write your code here
    }
}
