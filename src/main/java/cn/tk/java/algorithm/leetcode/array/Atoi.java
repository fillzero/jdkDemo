package cn.tk.java.algorithm.leetcode.array;

/*
*@date: 2017/9/16 0016
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: Implement atoi to convert a string to an integer.
* Hint:
*   Carefully consider all possible input cases. If you want a challenge,
* please do not see below and ask yourself what are the possible input cases.
*
* Notes:
*   It is intended for this problem to be specified vaguely (ie, no given input specs).
* You are responsible to gather all the input requirements up front.
*/
public class Atoi {
    /*
    * @description: 字符串转换为整数，一定要考虑到各种各样的情况，不是所有的字符串都可以转换成整数的
    */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        return Integer.valueOf(str);
    }
}
