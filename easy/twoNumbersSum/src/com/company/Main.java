package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static int[] twoNumbersSum(int[] nums, int target) {
        int[] numberIndex = new int[2];
        HashMap<Integer, Integer> mapSearch = new HashMap<>();
        for (int index = 0; index<nums.length; index++) {
            int numNeed = target - nums[index];
            if (mapSearch.containsKey(numNeed))
            {
                numberIndex[0] = index;
                numberIndex[1] = mapSearch.get(numNeed);
                break;
            }else {
                mapSearch.put(nums[index], index);
            }
        }
        return numberIndex;
    }
    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,3,2,6,9};
        int[] numsIndex = twoNumbersSum(nums, 8);
        System.out.println(numsIndex[0]);
        System.out.println(numsIndex[1]);
    }
}
