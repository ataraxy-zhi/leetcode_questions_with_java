package com.solution.onequestionperday.april2021.sumofsquarenumbers633;

/**
 * @ClassName SumOfSquareNumbers
 * @Description 633. Sum of Square Numbers
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 * <p>
 * Input: c = 3
 * Output: false
 * Example 3:
 * <p>
 * Input: c = 4
 * Output: true
 * Example 4:
 * <p>
 * Input: c = 2
 * Output: true
 * Example 5:
 * <p>
 * Input: c = 1
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= c <= 231 - 1
 * <p>
 * 633. 平方数之和
 * <p>
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 * <p>
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：c = 1
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= c <= 231 - 1
 * @Author yi
 * @Date 2021/4/28 8:26
 */
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        System.out.println(5.0 == 5);
    }
}


class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }
}

/**
 * 双指针
 */
class Solution2 {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
