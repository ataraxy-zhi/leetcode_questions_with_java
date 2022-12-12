package com.solution.onequestionperday.dec2022;

/**
 * 1781. 所有子字符串美丽值之和
 * 中等
 * 73
 * 相关企业
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 * <p>
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 * 示例 2：
 * <p>
 * 输入：s = "aabcbaa"
 * 输出：17
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 */
public class SumOfBeautyOfAllSubstrings1781 {
    public int beautySum(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int[] cnt = new int[26];
            for (int j = i; j < n; ++j) {
                ++cnt[s.charAt(j) - 'a'];
                int mi = 1000, mx = 0;
                for (int v : cnt) {
                    if (v > 0) {
                        mi = Math.min(mi, v);
                        mx = Math.max(mx, v);
                    }
                }
                ans += mx - mi;
            }
        }
        return ans;
    }
}
