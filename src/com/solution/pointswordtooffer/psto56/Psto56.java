package com.solution.pointswordtooffer.psto56;

/**
 * @ClassName Psto56
 * @Description 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 * <p>
 * 限制：
 * <p>
 * 2 <= nums.length <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/4/28 8:59
 */
public class Psto56 {
}

class Solution {
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        // 1. 遍历异或
        for (int num : nums) {
            n ^= num;
        }
        // 2. 循环左移，计算 m; m 表示的值（将二进制转换为十进制）的 2 次方根即为 x 异或 y 的为 1 的二进制位的序号（从右往左数）
        while ((n & m) == 0) {
            m <<= 1;
        }
        // 3. 遍历 nums 分组
        for (int num : nums) {
            // 4. 当 num & m != 0
            if ((num & m) != 0) {
                x ^= num;
            } else {
                // 4. 当 num & m == 0

                y ^= num;
            }
        }

        // 5. 返回出现一次的数字
        return new int[]{x, y};
    }
}
