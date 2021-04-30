package com.solution.onequestionperday.april2021.singlenumberii137;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SingleNumberII
 * @Description 137. Single Number II
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each element in nums appears exactly three times except for one element which appears once.
 * <p>
 * <p>
 * Follow up: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * <p>
 * 137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *  
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/4/30 21:15
 */
public class SingleNumberII {
}


class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }
}
