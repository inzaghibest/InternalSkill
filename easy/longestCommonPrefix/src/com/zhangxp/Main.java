package com.zhangxp;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 思路：设公共前缀为strPrefix = "",从字符串数组的第1个元素第一个字符开始，依次比较后边元素的第一个字符，如果全部相等。
 * strPrefix += 第一个字符，否则返回公共前缀。只到比较到某一个元素到达末尾。
 */
public class Main {
    public static String longestCommonPrefix(String[] strs) {
        // 临界值判断
        if (strs.length == 1) {
            return strs[0];
        }
        // 公共前缀
        String strPrefix = "";
        // 搜素每个元素的位置
        int start = 0;
        // 从第0个元素开始比较
        int index = 0;
        // 字符串数组的长度
        int len = strs.length;
        boolean bSame = true;
        // 当找到不一致时结束循环
        while(bSame) {
            // 比较前需要置为false,否则下边会出现""越界问题。
            bSame = false;
            // 从第0个元素开始依次比较
            while(index < len && (index+1) < len) {
                // 如果比较的位置没有达到该元素末尾，且相等，继续比较
                // 否则，表示已经不同了。
                if (start < strs[index].length() && start < strs[index + 1].length()
                        && (strs[index].charAt(start) == strs[index+1].charAt(start))) {
                    index++;
                    bSame = true;
                }
                else {
                    bSame = false;
                    break;
                }
            }
            // 退出循环时，如果比较结果相同，拼接公共前缀，否则退出循环。
            if (bSame) {
                strPrefix = strPrefix.concat(String.valueOf(strs[0].charAt(start)));
                start++;
                index = 0;
            }
        }
        return strPrefix;
    }
    public static void main(String[] args) {
	// write your code here
        String[] strs = {""};
        System.out.println(longestCommonPrefix(strs));
    }
}
