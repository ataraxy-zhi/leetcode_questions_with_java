package com.solution.simple.maximumsubarray53;

/**
 * @className: MaximumSubarray
 * @description: 给定一个整数数组 nums ，
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 * <p>
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 * <p>
 * <p>
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * @author: j
 * @date: 2020/3/23 9:34
 */
public class MaximumSubarray {

    public static void main(String[] args) {

    }

    public static int maxSum(int[] nums, int left, int right) {

        //判断边界条件 恰好只有一个元素
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;
        //左边最大子序和
        int leftSumMax = maxSum(nums, left, mid);
        //右边最大子序和
        int rightSumMax = maxSum(nums, mid + 1, right);

        int leftMax = Integer.MIN_VALUE;
        //在左序列中包含左边子序列最后一个元素的最大子序和
        int leftSum = 0;
        for (int i = mid; i >= left; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftSum, leftMax);
        }

        int rightMax = Integer.MIN_VALUE;
        //在右序列中包含右边子序列第一个一个元素的最大子序和
        int rightSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }

        //中间子序列最大和
        int midSumMax = leftMax + rightMax;

        //返回左边、中间以及右边子序和最大值
        return Math.max(Math.max(leftSumMax, rightSumMax), midSumMax);
    }

    public static int maxSubArray(int[] nums) {

        return maxSum(nums, 0, nums.length - 1);

    }
}


/**
 * 动态规划
 */
class Solution {
    public int maxSubArray(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] maxSum = new int[nums.length];
        maxSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSum[i] = Math.max(maxSum[i - 1] + nums[i], nums[i]);
        }

        int maxResult = maxSum[0];

        for (int i = 1; i < nums.length; i++) {
            maxResult = Math.max(maxResult, maxSum[i]);
        }

        return maxResult;
    }
}


class Solution2 {
    public int maxSubArray(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int maxSum = nums[0];
        int temp = 0;

        for (int num : nums) {
            temp = Math.max(temp + num, num);
            maxSum = Math.max(temp, maxSum);
        }

        return maxSum;
    }
}