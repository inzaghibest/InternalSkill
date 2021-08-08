package com.zhangxp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 1; i<=numRows; i++) {
            if (i == 1){
                List<Integer> list1 = new ArrayList<>();
                list1.add(1);
                list.add(list1);
            }
        }
    }
    public static void main(String[] args) {
	// write your code here
    }
}
