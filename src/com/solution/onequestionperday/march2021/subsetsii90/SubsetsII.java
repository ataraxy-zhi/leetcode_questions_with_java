package com.solution.onequestionperday.march2021.subsetsii90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName SubsetsII
 * @Description 90. Subsets II
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * <p>
 * <p>
 * <p>
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/3/31 9:12
 */
public class SubsetsII {
}


class Solution {
    List<Integer> l;
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        l = new ArrayList<>();
        res = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, false);
        return res;
    }

    public void subsetsWithDup(int[] nums, int i, boolean choosePre) {
        if (i == nums.length) {
            res.add(new ArrayList(l));
            return;
        }
        // 2 2 2 2
        l.add(nums[i]);
        subsetsWithDup(nums, i + 1, true);
        l.remove(l.size() - 1);

        if (choosePre && nums[i - 1] == nums[i]) {
            return;
        }
        subsetsWithDup(nums, i + 1, false);
    }
}
