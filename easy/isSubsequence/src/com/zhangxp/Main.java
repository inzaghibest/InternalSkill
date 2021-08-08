package com.zhangxp;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class Main {
    /**
     * 思路：由子串定义可知，子串在原始串中出现的顺序是不变的。
     * 由此，我们设置i=0,为原始串的起始位置，j=0为子串的起始位置。
     * 从i开始，依次和子串的第j个字符比较，如果有s[i] = t[j], 则i++,j++,如果s[i]!=t[j],则i++
     * 如果找到了j的末尾，有s[i] == t[j], 则返回ture.否则，返回false;
     * @param s 子串
     * @param t 原始串
     * @return s是否为t的子串
     */
    public static boolean isSubsequence(String s, String t) {
        int lenSub = s.length();
        int lenOrg = t.length();
        int i = 0; // 原始串t的的起始位置
        int j = 0; // 子串s的起始位置
        while(i<lenOrg && j<lenSub){
            if (t.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return j == lenSub;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(isSubsequence( "ac","afdceeee"));
    }
}
