package com.solution.onequestionperday.march2021.palindromepartitioningii132;

/**
 * @ClassName PalindromePartitioningII
 * @Description 132. Palindrome Partitioning II
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * Example 2:
 * <p>
 * Input: s = "a"
 * Output: 0
 * Example 3:
 * <p>
 * Input: s = "ab"
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 2000
 * s consists of lower-case English letters only.
 * <p>
 * <p>
 * 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：s = "ab"
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * @Author
 * @Date 2021/3/8 8:56
 */
public class PalindromePartitioningII {

    static class Solution {
        public int minCut(String s) {
            int len = s.length();
            char[] ch = s.toCharArray();
            boolean[][] isPalindrome = new boolean[len][len];

            for (int i = len - 1; i >= 0; i--) {
                for (int j = i; j < len; j++) {
                    isPalindrome[i][j] = (ch[i] == ch[j]) && (i + 1 > j - 1 || isPalindrome[i + 1][j - 1]);
                }
            }

            int[] dp = new int[len];

            for (int i = 0; i < len; i++) {
                if (isPalindrome[0][i]) {
                    dp[i] = 0;
                } else {
                    dp[i] = Integer.MAX_VALUE;
                    for (int j = 0; j < i; j++) {
                        if (isPalindrome[j + 1][i]) {
                            dp[i] = Math.min(dp[i], dp[j] + 1);
                        }
                    }
                }
            }

            return dp[len - 1];
        }
    }
}
