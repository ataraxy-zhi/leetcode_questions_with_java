package com.solution.onequestionperday.march2023;

/**
 * 982. 按位与为零的三元组
 * 困难
 * 114
 * 相关企业
 * 给你一个整数数组 nums ，返回其中 按位与三元组 的数目。
 * <p>
 * 按位与三元组 是由下标 (i, j, k) 组成的三元组，并满足下述全部条件：
 * <p>
 * 0 <= i < nums.length
 * 0 <= j < nums.length
 * 0 <= k < nums.length
 * nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,3]
 * 输出：12
 * 解释：可以选出如下 i, j, k 三元组：
 * (i=0, j=0, k=1) : 2 & 2 & 1
 * (i=0, j=1, k=0) : 2 & 1 & 2
 * (i=0, j=1, k=1) : 2 & 1 & 1
 * (i=0, j=1, k=2) : 2 & 1 & 3
 * (i=0, j=2, k=1) : 2 & 3 & 1
 * (i=1, j=0, k=0) : 1 & 2 & 2
 * (i=1, j=0, k=1) : 1 & 2 & 1
 * (i=1, j=0, k=2) : 1 & 2 & 3
 * (i=1, j=1, k=0) : 1 & 1 & 2
 * (i=1, j=2, k=0) : 1 & 3 & 2
 * (i=2, j=0, k=1) : 3 & 2 & 1
 * (i=2, j=1, k=0) : 3 & 1 & 2
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：27
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] < 216
 */
public class TriplesWithBitwiseAndEqualToZero982 {
    /**
     * 怎么在暴力法的基础上优化时间，目前时间复杂度是 O(n^3)
     * 1.用空间换时间
     * 2.方法优化
     * 与的运算：
     * a & a = a
     * a & b = 0 ==> a & b & a = 0, a & b & b = 0
     * <p>
     * <p>
     * <p>
     * 沃尔什变换
     *
     * @param nums
     * @return
     */
    public static int countTriplets(int[] nums) {
        int countSum = 0;

        for (int num : nums) {
            for (int num1 : nums) {
                for (int num2 : nums) {
                    if ((num & num1 & num2) == 0) {
                        countSum += 1;
                    }

                }
            }
        }

        return countSum;
    }


    class Solution {
        public int countTriplets(int[] nums) {
            int u = 1;
            for (int x : nums)
                while (u <= x)
                    u <<= 1;
            int[] cnt = new int[u];
            cnt[0] = nums.length; // 直接统计空集
            for (int m : nums) {
                m ^= u - 1;
                for (int s = m; s > 0; s = (s - 1) & m) // 枚举 m 的非空子集
                    ++cnt[s];
            }
            int ans = 0;
            for (int x : nums)
                for (int y : nums)
                    ans += cnt[x & y];
            return ans;
        }
    }
}
