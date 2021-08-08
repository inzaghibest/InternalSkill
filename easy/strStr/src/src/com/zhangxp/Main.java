package com.zhangxp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 *
 * 结题思路:
 * 设置下标i=0,j=0;分别指向haystack和needle起始位置，另设置index=0,记录首次出现的位置。
 * 如果有needle[j] == haystack[i], index=i, 则分别i++,j++,
 * 如果haystack[i] != needle[j], 则i不变,j=0,继续比较。
 * 如果退出比较时，有j==needle.length,则说明找到了子串。
 */
public class Main {

    public static void test() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
    }
    public static int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int index = 0;
        boolean bFind = false;
        while(i<haystack.length() && j<needle.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
                i++;
                if (!bFind){
                    bFind = true;
                    index = i;
                }
            }else{
                j=0;
                if (bFind) {
                    i = index+1;
                }
                bFind = false;
            }
        }
        if (j == needle.length()) {
            return index;
        }
        return -1;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(strStr("mississippi","issip"));
    }
}
