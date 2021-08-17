package com.zhangxp;

/**
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。
 * 记录中只含下面三种字符：
 *
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 *
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 *
 *示例 1：
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 *
 * 示例 2：
 * 输入：s = "PPALLL"
 * 输出：false
 * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
 *
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s[i] 为 'A'、'L' 或 'P'
 *
 */
public class Main {

    /**
     * 解题思路： 学生不满足出勤奖励的条件有两个，任意一个达到即不满足。因此，我们再遍历字符串时需要同时判断是否达到了
     * 这两个条件，如果遍历过程中达到了其中一个条件，则立即返回false.如果遍历到字符串结尾，都没有达到，则返回true.
     * 条件一：缺勤'A'少于两天，为此我们设置变量i=0,如果遍历中s[index] == 'A', 则i+1, 如果i>1,则不满足。
     * 条件二: 不连续迟到三天即以上'LLL',为此，我们设置变量j=0表示迟到的天数。每次判断字符时,如果为'L',则j++,
     * 否则，将j=0.从而达到连续的效果。
     * @param s
     * @return
     */
    public static boolean checkRecord(String s) {
        // 缺勤天数
        short absenceFromDuty = 0;
        // 连续迟到天数
        short late = 0;
        for (int i = 0; i<s.length(); i++){
            if (s.charAt(i) == 'A'){
                absenceFromDuty++;
            }
            if (s.charAt(i) == 'L'){
                late++;
            }else{
                late = 0;
            }
            if (absenceFromDuty == 2 || late == 3) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
	// write your code here
        String s = "P";
        System.out.println(checkRecord(s));
    }
}
