package com.solution.onequestionperday.march2021.russiandollenvelopes354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName RussianDollEnvelopes
 * @Description 354. Russian Doll Envelopes
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * <p>
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * <p>
 * Note:
 * Rotation is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * <p>
 * <p>
 * <p>
 * 354. 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 说明:
 * 不允许旋转信封。
 * <p>
 * 示例:
 * <p>
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 通过次数27,224提交次数68,620
 * <p>
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * @Author
 * @Date 2021/3/4 9:51
 */
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes.length == 0) {
            return 0;
        }

        // 前一个升序排列，后一个降序排列
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        int[] dp = new int[envelopes.length];
        int maxLen = 1;
        Arrays.fill(dp, 1);

        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
