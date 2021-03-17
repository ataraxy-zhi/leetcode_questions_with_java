package com.solution.onequestionperday.march2021.distinctsubsequences115;

/**
 * 115. Distinct Subsequences Given two strings s and t, return the number of
 * distinct subsequences of s which equals t.
 * 
 * A string's subsequence is a new string formed from the original string by
 * deleting some (can be none) of the characters without disturbing the
 * remaining characters' relative positions. (i.e., "ACE" is a subsequence of
 * "ABCDE" while "AEC" is not).
 * 
 * It is guaranteed the answer fits on a 32-bit signed integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "rabbbit", t = "rabbit" Output: 3 Explanation: As shown below,
 * there are 3 ways you can generate "rabbit" from S. rabbbit rabbbit rabbbit
 * Example 2:
 * 
 * Input: s = "babgbag", t = "bag" Output: 5 Explanation: As shown below, there
 * are 5 ways you can generate "bag" from S. babgbag babgbag babgbag babgbag
 * babgbag
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length, t.length <= 1000 s and t consist of English letters.
 * 
 * 
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 
 * 字符串的一个 子序列
 * 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 
 * 题目数据保证答案符合 32 位带符号整数范围。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：s = "rabbbit", t = "rabbit" 输出：3 解释： 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母) rabbbit ^^^^ ^^ rabbbit ^^ ^^^^ rabbbit ^^^ ^^^ 示例 2：
 * 
 * 输入：s = "babgbag", t = "bag" 输出：5 解释： 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 (上箭头符号
 * ^ 表示选取的字母) babgbag ^^ ^ babgbag ^^ ^ babgbag ^ ^^ babgbag ^ ^^ babgbag ^^^  
 * 
 * 提示：
 * 
 * 0 <= s.length, t.length <= 1000 s 和 t 由英文字母组成
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DistinctSubsequences {

}

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
