package com.solution.onequestionperday.may2021.hammingdistance461;

/**
 * @ClassName HammingDistance
 * @Description 461. Hamming Distance
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, return the Hamming distance between them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 * Example 2:
 * <p>
 * Input: x = 3, y = 1
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= x, y <= 231 - 1
 * <p>
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/5/27 16:44
 */
public class HammingDistance {
}


class Solution {
    public int hammingDistance(int x, int y) {
        int s = x ^ y, cnt = 0;
        while (s != 0) {
            cnt += s & 1;
            s >>= 1;
        }
        return cnt;
    }
}
