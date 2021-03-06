package com.solution.onequestionperday.march2021.nextgreaterelementii503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName NextGreaterElementII
 * @Description 503. Next Greater Element II
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 * <p>
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * @Author
 * @Date 2021/3/6 8:56
 */
public class NextGreaterElementII {

    /**
     * 初步解法
     */
    static class Solution {
        public int[] nextGreaterElements(int[] nums) {

            int len = nums.length;
            int[] result = new int[len];
            int[] arr = new int[2 * len];

            for (int i = 0; i < len; i++) {
                arr[i] = nums[i];
            }

            for (int i = len; i < 2 * len; i++) {
                arr[i] = arr[i - len];
            }

            for (int i = 0; i < len; i++) {
                int flag = 0;
                for (int j = i; j < 2 * len; j++) {
                    if (nums[i] < arr[j]) {
                        result[i] = arr[j];
                        flag = 1;
                        break;
                    }
                }

                if (flag == 0) {
                    result[i] = -1;
                }
            }

            return result;
        }
    }

    /**
     * 借助单调栈   注意Stack类已经过时
     */
    static class Solution2 {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Arrays.fill(res, -1);
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < n * 2; i++) {
                int num = nums[i % n];
                while (!stack.isEmpty() && num > nums[stack.peek()]) {
                    res[stack.pop()] = num;
                }
                if (i < n) {
                    stack.add(i);
                }
            }
            return res;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] arr = new int[2 * nums.length];


    }
}
