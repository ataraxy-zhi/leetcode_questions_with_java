package com.solution.onequestionperday.april2023;

/**
 * 2427. 公因子的数目
 * 提示
 * 简单
 * 40
 * 相关企业
 * 给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
 * <p>
 * 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 12, b = 6
 * 输出：4
 * 解释：12 和 6 的公因子是 1、2、3、6 。
 * 示例 2：
 * <p>
 * 输入：a = 25, b = 30
 * 输出：2
 * 解释：25 和 30 的公因子是 1、5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a, b <= 1000
 */
public class NumberOfCommonFactors2427 {

    public int commonFactors(int a, int b) {
        int g = gcd(a, b);
        int ans = 0;
        for (int x = 1; x * x <= g; ++x) {
            if (g % x == 0) {
                ++ans;
                if (x * x < g) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
