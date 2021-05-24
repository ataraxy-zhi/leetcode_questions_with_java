package com.solution.onequestionperday.may2021.strangeprinter664;

/**
 * @ClassName StrangePrinter
 * @Description 664. Strange Printer
 * There is a strange printer with the following two special properties:
 * <p>
 * The printer can only print a sequence of the same character each time.
 * At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.
 * Given a string s, return the minimum number of turns the printer needed to print it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aaabbb"
 * Output: 2
 * Explanation: Print "aaa" first and then print "bbb".
 * Example 2:
 * <p>
 * Input: s = "aba"
 * Output: 2
 * Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s consists of lowercase English letters.
 * <p>
 * 664. 奇怪的打印机
 * 有台奇怪的打印机有以下两个特殊要求：
 * <p>
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：s = "aaabbb"
 * 输出：2
 * 解释：首先打印 "aaa" 然后打印 "bbb"。
 * 示例 2：
 * <p>
 * 输入：s = "aba"
 * 输出：2
 * 解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strange-printer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/5/24 10:14
 */
public class StrangePrinter {
}


class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i][j - 1];
                } else {
                    int minn = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = minn;
                }
            }
        }
        return f[0][n - 1];
    }
}
