package com.zhangxp;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int distributeCandies(int candyType[]) {
        if (candyType.length <= 0) {
            return 0;
        }
        int type = 0;
        Map hashMap = new HashMap<Integer, Integer>();
        for (int index = 0; index < candyType.length; index++) {
            if (!hashMap.containsKey(candyType[index])) {
                hashMap.put(candyType[index], index);
                type++;
            }
        }
        return candyType.length/2 > type ? type : candyType.length/2;
    }
    public static void main(String[] args) {

    }
}
