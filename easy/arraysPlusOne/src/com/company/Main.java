package com.company;

import java.lang.reflect.Array;

public class Main {
    public static int[] plusOne(int[] digits) {
        int last = digits.length - 1;
        while(last != 0)
        {
            if(digits[digits.length - 1] == 9)
            {
                digits[last] = 0;
                last--;
                digits[last] += 1;
            }else if(digits[last] > 9){
                digits[last] = 0;
                last --;
                digits[last] ++;
            }else{
                digits[last] += 1;
            }
        }
        if(last == 0)
        {
            if(digits[last] >= 9) {
                int[] array = new int[digits.length + 1];
                array[0] = 1;
                for (int index = 1; index<array.length; index++) {
                    array[index] = 0;
                }
                return array;
            }
        }
        return digits;
    }
    public static void main(String[] args) {
	    int[] array = plusOne(new int[]{3, 9, 9,8});
	    for (int i = 0; i<array.length; i++) {
	        System.out.println(array[i]);
        }
    }
}
