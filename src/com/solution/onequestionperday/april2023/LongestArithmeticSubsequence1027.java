package com.solution.onequestionperday.april2023;

import java.util.Arrays;

/**
 * 1027. 最长等差数列
 * 中等
 * 295
 * 相关企业
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 * <p>
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 * <p>
 * 输入：nums = [9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 * <p>
 * 输入：nums = [20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 */
public class LongestArithmeticSubsequence1027 {
    public int longestArithSeqLength(int[] nums) {
        // 记录答案最大等差数列
        int res = 0;
        // dp数组：以 nums[i] 这个数结尾的，公差为 [j] 的最长等差子序列长度
        int[][] dp = new int[nums.length][1001];
        // base case
        for (int[] row : dp) {
            Arrays.fill(row, 1);
        }
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 与 nums[0] ~ nums[i-1] 中的任意一个数生成等差数列
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + 500;
                // 取最大值
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                // 更新答案
                res = Math.max(res, dp[i][diff]);
            }
        }
        return res;
    }
}
