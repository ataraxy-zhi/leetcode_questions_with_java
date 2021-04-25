package com.solution.pointswordtooffer.psto53;

/**
 * @ClassName Psto53
 * @Description 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 *  
 * <p>
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/4/25 12:19
 */
public class Psto53 {
}


class Solution {
    public int search(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if (j >= 0 && nums[j] != target) {
            return 0;
        }
        // 搜索左边界 left
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }
}


class Solution2 {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}

