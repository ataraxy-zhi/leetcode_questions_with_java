package com.solution.onequestionperday.april2023;

/**
 * 1053. 交换一次的先前排列
 * 提示
 * 中等
 * 118
 * 相关企业
 * 给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
 *
 * 如果无法这么操作，就请返回原数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1]
 * 输出：[3,1,2]
 * 解释：交换 2 和 1
 * 示例 2：
 *
 * 输入：arr = [1,1,5]
 * 输出：[1,1,5]
 * 解释：已经是最小排列
 * 示例 3：
 *
 * 输入：arr = [1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：交换 9 和 7
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 104
 * 提示
 * 中等
 * 118
 * 相关企业
 * 给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
 *
 * 如果无法这么操作，就请返回原数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1]
 * 输出：[3,1,2]
 * 解释：交换 2 和 1
 * 示例 2：
 *
 * 输入：arr = [1,1,5]
 * 输出：[1,1,5]
 * 解释：已经是最小排列
 * 示例 3：
 *
 * 输入：arr = [1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：交换 9 和 7
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 104
 */
public class PreviousPermutationWithOneSwap1053 {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int left = -1, right = 0;

        // 从右往左找，找出第一个满足 A[i] > A[i+1] 的数
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                left = i;
                break;
            }
        }

        // 如果没有这个数，就返回
        if (left == -1) {
            return arr;
        }

        // 在A[i] 右边找仅小于 A[i] 的数（小于A[i]的最大值的最左侧位置）
        int max = 0;
        for (int i = left + 1; i < n; i++) {
            if (arr[i] < arr[left] && max < arr[i]) {
                max = arr[i];
                right = i;
            }
        }

        // 交换
        int t = arr[left];
        arr[left] = arr[right];
        arr[right] = t;

        return arr;
    }
}
