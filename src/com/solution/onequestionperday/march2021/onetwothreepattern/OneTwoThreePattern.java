package com.solution.onequestionperday.march2021.onetwothreepattern;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName OneTwoThreePattern
 * @Description 456. 132 Pattern
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
 * <p>
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 * <p>
 * Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or the O(n) solution?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * <p>
 * Input: nums = [3,1,4,2]
 * Output: true
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * <p>
 * Input: nums = [-1,3,2,0]
 * Output: true
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * 456. 132模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/3/24 12:13
 */
public class OneTwoThreePattern {
}


class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return false;
        }

        //min[i]表示 nums[0]到nums[i]的最小值
        int[] min = new int[len];
        min[0] = nums[0];
        for (int i = 1; i < len; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        // stack 用来维护可能的 2
        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[len - 1]);

        // 枚举 1
        // 从后往前遍历，stack 中的数字表示的是从位置 j 到 n 中，大于 min[j] 且小于 nums[j] 的数
        for (int j = len - 2; j >= 1; j--) {
            if (nums[j] > min[j]) {


                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }

                //此时栈顶元素一定大于min[j]
                if (!stack.isEmpty() && nums[j] > stack.peek()) {
                    return true;
                }


                // 对于可能的 2 （大于 min[j] 的，对于枚举的 1 来讲，它也有机会成为 2）入栈
                stack.push(nums[j]);


            }
        }

        return false;
    }
}


class Solution2 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        // 单调栈，维护 2
        Deque<Integer> candidateK = new LinkedList<>();
        candidateK.push(nums[n - 1]);
        // 记录 2 的最大值
        int maxK = Integer.MIN_VALUE;

        // 从后往前枚举 1
        for (int i = n - 2; i >= 0; i--) {

            // nums[i] 可以作为 1
            if (nums[i] < maxK) {
                return true;
            }

            // nums[i] 可以作为 3 ，找出真正 2 的最大值
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }

            // 将可能为 2 的值入栈
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }
}
