package com.solution.simple.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:
 * @description: 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ， 使得 a + b + c = 0.
 * 找出所有满足条件且不重复的三元组。注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0,1, 2, -1, -4]，满足要求的三元组集合为： [[-1, 0, 1], [-1, -1, 2]]
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum
 * 解题参考源码：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
 * @date: 2019/11/29 9:54
 */
public class SumOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }

    }

    //leetcode
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        //数组为空或者数组长度小于3时直接返回原数组
        if (nums == null || nums.length < 3) {
            return result;
        }

        //排序，默认从小到大(目的是为了方便后续的扫描)
        Arrays.sort(nums);

        //从数组的第一个数开始依次开始判断（为其找另外两个数，一个从左边（不包括它自己）开始寻找，一个从最右边开始寻找）
        for (int i = 0; i < nums.length - 2; i++) {

            //排完序后，从左到右数字依次递增，如果左边的数字大于0的话，那么就不可能找到三个数使其和为0
            if (nums[i] > 0) {
                break;
            }

            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //left从前往后扫描，right从后往前扫描
            int left = i + 1;
            int right = nums.length - 1;

            //确保在数组范围内再进行判读
            while (left < right) {
                //left往后移的条件：三数之和小于0，说明左边的数小了，要选择稍大点的数；出现重复情况
                if (nums[left] + nums[right] + nums[i] < 0 ||
                        (left > i + 1 && nums[left] == nums[left - 1])) {
                    left++;
                } else if (nums[left] + nums[right] + nums[i] > 0 ||
                        (right < nums.length - 1 && nums[right] == nums[right + 1])) {
                    //right往后移的条件：三数之和大于0，说明右边的数打了，需选择稍小点的数；出现重复情况
                    right--;
                } else {
                    //三数满足条件
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left++]);
                    list.add(nums[right--]);
                    result.add(list);

                }
            }
        }

        return result;
    }
}

