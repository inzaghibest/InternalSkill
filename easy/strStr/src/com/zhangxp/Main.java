package com.zhangxp;

public class Main {
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle == "")
        {
            return 0;
        }
        int nStart = 0;
        int nFind = 0;
        while(nStart <= haystack.length()) {
            while(nFind <= needle.length()) {
                if (haystack.charAt(nStart) == needle.charAt(nFind)) {
                    nFind++;
                    nStart++;
                }else{
                    nStart++;
                    nFind = 0;
                }
            }
        }
        if (nFind == needle.length())
        {
            return nStart;
        }
        return -1;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(strStr("helloworld", "world"));
    }
}
