package com.solution.medium.minimumsizesubarraysum209;

/**
 * 209. Minimum Size Subarray Sum Given an array of positive integers nums and a
 * positive integer target, return the minimal length of a contiguous subarray
 * [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or
 * equal to target. If there is no such subarray, return 0 instead.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: target = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: The subarray
 * [4,3] has the minimal length under the problem constraint. Example 2:
 * 
 * Input: target = 4, nums = [1,4,4] Output: 1 Example 3:
 * 
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1] Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= target <= 109 1 <= nums.length <= 105 1 <= nums[i] <= 105
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log(n)).
 * 
 * 
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr]
 * ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：target = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。 示例 2：
 * 
 * 输入：target = 4, nums = [1,4,4] 输出：1 示例 3：
 * 
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1] 输出：0  
 * 
 * 提示：
 * 
 * 1 <= target <= 109 1 <= nums.length <= 105 1 <= nums[i] <= 105  
 * 
 * 进阶：
 * 
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumSizeSubarraySum {

}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = -1;
        int sum = 0;
        int result = n + 1;

        while (right < n) {
            // 增大滑动窗口
            while (right < n) {
                right++;
                if (right < n) {
                    sum += nums[right];
                }

                if (sum >= target) {
                    result = Math.min(result, right - left + 1);
                    break;
                }
            }

            // 滑到最右
            if (right == n) {
                break;
            }

            // 缩小滑动窗口
            while (left < right) {
                sum -= nums[left];
                left++;
                if (sum >= target) {
                    result = Math.min(result, right - left + 1);
                } else {
                    break;
                }
            }
        }

        if (result == (n + 1)) {
            return 0;
        } else {
            return result;
        }
    }
}