package com.zhangxp;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * ASCII码大小写字母之间相差32.
 * 大写字母65~90,小写字母97~122.
 * 数字字符是48~57
 */
public class Main {
    public static boolean isLegal(char s) {
        return 64 < (int) s && (int) s < 91 || (int) s > 96 && (int) s < 123 || (int) s > 47 && (int) s < 58;
    }
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s.replaceAll()
        StringBuilder reverseStr = new StringBuilder();
        int index = s.length() - 1;
        while(index > 0) {
            char c = s.charAt(index);
            if (isLegal(c)) {
                reverseStr.append(c);

            }
            index--;
        }


        return false;
    }
    public static void main(String[] args) {
	// write your code here
        char s = 89;
        System.out.println(s);
    }
}
