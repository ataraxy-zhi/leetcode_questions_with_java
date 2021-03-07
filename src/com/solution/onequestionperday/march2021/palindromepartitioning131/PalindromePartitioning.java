package com.solution.onequestionperday.march2021.palindromepartitioning131;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName PalindromePartitioning
 * @Description 131. Palindrome Partitioning
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * <p>
 * A palindrome string is a string that reads the same backward as forward.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * <p>
 * Input: s = "a"
 * Output: [["a"]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 * <p>
 * <p>
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * @Author
 * @Date 2021/3/7 13:35
 */
public class PalindromePartitioning {
    static class Solution {
        public List<List<String>> partition(String s) {
            int len = s.length();
            List<List<String>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            char[] charArray = s.toCharArray();
            // 预处理
            // 状态：dp[i][j] 表示 s[i][j] 是否是回文
            boolean[][] dp = new boolean[len][len];
            // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
            for (int right = 0; right < len; right++) {
                // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
                for (int left = 0; left <= right; left++) {
                    if (charArray[left] == charArray[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                        dp[left][right] = true;
                    }
                }
            }

            Deque<String> stack = new ArrayDeque<>();
            dfs(s, 0, len, dp, stack, res);
            return res;
        }

        private void dfs(String s, int index, int len, boolean[][] dp,
                         Deque<String> path, List<List<String>> res) {
            if (index == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i < len; i++) {
                if (dp[index][i]) {
                    path.addLast(s.substring(index, i + 1));
                    dfs(s, i + 1, len, dp, path, res);
                    path.removeLast();
                }
            }
        }


    }
}
