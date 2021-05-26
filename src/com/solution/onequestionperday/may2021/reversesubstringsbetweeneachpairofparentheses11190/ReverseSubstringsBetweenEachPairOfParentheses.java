package com.solution.onequestionperday.may2021.reversesubstringsbetweeneachpairofparentheses11190;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName ReverseSubstringsBetweenEachPairOfParentheses
 * @Description 1190. Reverse Substrings Between Each Pair of Parentheses
 * You are given a string s that consists of lower case English letters and brackets.
 * <p>
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 * <p>
 * Your result should not contain any brackets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(abcd)"
 * Output: "dcba"
 * Example 2:
 * <p>
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * Explanation: The substring "love" is reversed first, then the whole string is reversed.
 * Example 3:
 * <p>
 * Input: s = "(ed(et(oc))el)"
 * Output: "leetcode"
 * Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 * Example 4:
 * <p>
 * Input: s = "a(bcdefghijkl(mno)p)q"
 * Output: "apmnolkjihgfedcbq"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 2000
 * s only contains lower case English characters and parentheses.
 * It's guaranteed that all parentheses are balanced.
 * <p>
 * 1190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/5/26 23:11
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {
}


class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        int index = 0, step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }
}
