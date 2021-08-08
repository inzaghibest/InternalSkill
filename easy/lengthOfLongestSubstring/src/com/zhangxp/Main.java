package com.zhangxp;
//给定一个字符串s ，请你找出其中不含有重复字符的最长子串的长度。

import java.util.HashMap;
import java.util.Map;

/**
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * @author Administrator
 */
public class Main {
    public static int lengthOfLongestSubstring(String s) {
        /**
         * 思路:从字符串的第一个字符开始，开始位置即为index=0,最大长度即为max = 1.
         * index开始向后移动并判断是否在前面的串中出现过，如果没有出现max+1,index++,
         * 如果出现了,则将搜寻开始位置置位出现的位置+1.
         * 每次搜到重复数字，获取当前长度与之前最大长度比较，如果比之前的大，更新max的值。
         * 当搜索到字符串最后一个元素，返回max.
         *
         * 关键点：如果判断在前面的串中是否出现过？hashMap<key,value>, key为元素值,value记录下标,这样效率
         * 就为O(1).
         *
         */
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        int curMax = 0;
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int preRemoveLocation = 0;
        int index = 0;
        while(index < s.length()) {
            char cChar = s.charAt(index);
            if (hashMap.containsKey(cChar)){  // 如果该字符之前出现过
                  // 重复元素的位置
                  int repeatLocation = hashMap.get(cChar);
                  // 移除上次移除元素位置与这次位置之间的元素
                  while(preRemoveLocation <= repeatLocation) {
                      hashMap.remove(s.charAt(preRemoveLocation));
                      preRemoveLocation++;
                  }
                  hashMap.put(cChar, index); // 并将当前元素放入hashMap.
                  int curLocation = index;
                  index  += 1; // 则从出现重复的位置+1处继续寻找
                  if (curMax > max) {
                      max = curMax;
                  }
                  // 此时有curMax
                  curMax = curLocation - repeatLocation;
            }else{
                curMax++;
                hashMap.put(s.charAt(index), index);
                index++;
            }
        }
        return max>curMax?max:curMax;
    }
    public static void main(String[] args) {
	// write your code here
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
