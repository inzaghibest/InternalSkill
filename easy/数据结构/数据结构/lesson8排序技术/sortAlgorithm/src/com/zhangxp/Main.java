package com.zhangxp;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums1 = {1,2,3,4,5,6,7,8};
        int[] nums2 = {8,7,6,5,4,3,2,1};
        int[] nums3 = {};
        int[] nums4 = {1};
        int[] nums5 = {32,22,51,69,81,3,2,7,1,6,5,11,22,10,30};
//        sortAlgorithm.insertSort(nums1);
//        sortAlgorithm.insertSort(nums2);
//        sortAlgorithm.insertSort(nums3);
//        sortAlgorithm.insertSort(nums4);
//        sortAlgorithm.insertSort(nums5);
//        sortAlgorithm.shellSort(nums1);
//        sortAlgorithm.shellSort(nums2);
//        sortAlgorithm.shellSort(nums3);
//        sortAlgorithm.shellSort(nums4);
//        sortAlgorithm.shellSort(nums5);
//          sortAlgorithm.bubbleSort(nums1);
//          sortAlgorithm.bubbleSort(nums2);
//          sortAlgorithm.bubbleSort(nums3);
//          sortAlgorithm.bubbleSort(nums4);
//          sortAlgorithm.bubbleSort(nums5);
//        sortAlgorithm.quickSort(nums1, 0, nums1.length-1);
//        sortAlgorithm.quickSort(nums2, 0, nums2.length-1);
//        sortAlgorithm.quickSort(nums3, 0, nums3.length-1);
//        sortAlgorithm.quickSort(nums4, 0, nums4.length-1);
//        sortAlgorithm.quickSort(nums5, 0, nums5.length-1);
//          sortAlgorithm.simpleSelectionSort(nums1);
//          sortAlgorithm.simpleSelectionSort(nums2);
//          sortAlgorithm.simpleSelectionSort(nums3);
//          sortAlgorithm.simpleSelectionSort(nums4);
//          sortAlgorithm.simpleSelectionSort(nums5);
//        sortAlgorithm.heapSort(nums1);
//        sortAlgorithm.heapSort(nums2);
//        sortAlgorithm.heapSort(nums3);
//        sortAlgorithm.heapSort(nums4);
//        sortAlgorithm.heapSort(nums5);
        int[] nums11 = new int[8];
        sortAlgorithm.mergeSortNoRecursion(nums1, nums11, 8);
        int[] nums22 = new int[8];
        sortAlgorithm.mergeSortNoRecursion(nums2, nums22, 8);
        int[] nums44 = new int[1];
        sortAlgorithm.mergeSortNoRecursion(nums4, nums44, 1);
        int[] nums55 = new int[15];
        sortAlgorithm.mergeSortNoRecursion(nums5, nums55, 15);
        for (int i: nums1){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i: nums2){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i: nums3){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i: nums4){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i: nums5){
            System.out.print(i + " ");
        }
    }
}
