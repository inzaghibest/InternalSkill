package com.zhangxp;

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用单个或多个连续的空格字符隔开。
 * 返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回0 。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 *
 * 输入：s = " "
 * 输出：0
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 *
 */
public class Main {
    /**
     *
     * @param s 字符串
     * @return 。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
     * 解法一：从字符串起始位置开始处遍历，遍历位置记为index = 0;并设置两个长度，一个长度记为preLen,表示之前找到的一个字符长度,
     * 另一个标记为curLen,表示找到空格后，之后字符串的长度。
     * 如果找到了空字符，将当前长度赋值给之前的长度，并将当前长度置为0，并要判断curLen此时是否已为0,已为0的话不能再赋值给preLen.
     * 说明连续的空字符。如果不是空字符，将当前长度+1.这样找到字符串末尾时，如果curLen不为0，返回curLen.如果curLen ==0,表示
     * 字符串结尾全部是空字符，返回preLen.
     */
    public static int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int index = 0;
        int preLen = 0;
        int curLen = 0;
        while(index<s.length()) {
            if (s.charAt(index)== ' ') {
                if (curLen != 0) {
                    preLen = curLen;
                }
                curLen = 0;
            }else{ //
                curLen++;
            }
            index++;
        }
        return curLen>0?curLen:preLen;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(lengthOfLastWord("   "));
    }
}
