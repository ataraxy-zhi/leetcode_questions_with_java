package com.solution.pointswodatoffer.duplicatenumberinarray3;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DuplicateNumberInArray3
 * @Description 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @Author
 * @Date 2021/3/8 15:09
 */
public class DuplicateNumberInArray {

}

/**
 * 辅助数组
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        // 辅助数组
        int[] flag = new int[n];

        // 记录各个数字出现次数
        for (int num : nums) {
            flag[num]++;
        }

        // 返回重复的数（这里返回第一个重复的数）
        for (int i = 0; i < n; i++) {
            if (flag[i] > 1) {
                return i;
            }
        }

        // 没有重复的情形
        return -1;

    }
}

/**
 * 哈希表
 */
class Solution2 {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> hashmap = new HashMap<>();

        // 将数字依次加入哈希表中
        for (int num : nums) {
            if (hashmap.containsKey(num)) {
                return num;
            }

            // 这里并不心其值如何（可以为任意），关键是键不能重复
            hashmap.put(num, 0);
        }

        // 没有重复的情形
        return -1;
    }
}

/**
 * 原地置换
 */
class Solution3 {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;

        // 就地判断nums[i]是否等于nums[nums[i]]
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                int temp = nums[i];
                // 出现重复
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                } else {
                    // 未重复，则交换位置

                    nums[i] = nums[nums[i]];
                    nums[temp] = temp;
                }
            }
        }

        // 没有重复的情形
        return -1;

    }
}
