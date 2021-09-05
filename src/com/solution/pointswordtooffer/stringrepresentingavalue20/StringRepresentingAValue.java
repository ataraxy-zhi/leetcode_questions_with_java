package com.solution.pointswordtooffer.stringrepresentingavalue20;

/**
 * 剑指 Offer 20. 表示数值的字符串 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class StringRepresentingAValue {

}

class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        int index = 0;
        boolean hasNum = false, hasE = false;
        boolean hasSign = false, hasDot = false;
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        while (index < n) {
            while (index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                index++;
                hasNum = true;
            }
            if (index == n) {
                break;
            }
            char c = s.charAt(index);
            if (c == 'e' || c == 'E') {
                if (hasE || !hasNum) {
                    return false;
                }
                hasE = true;
                hasNum = false;
                hasSign = false;
                hasDot = false;
            } else if (c == '+' || c == '-') {
                if (hasSign || hasNum || hasDot) {
                    return false;
                }
                hasSign = true;
            } else if (c == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (c == ' ') {
                break;
            } else {
                return false;
            }
            index++;
        }
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        return hasNum && index == n;
    }
}
