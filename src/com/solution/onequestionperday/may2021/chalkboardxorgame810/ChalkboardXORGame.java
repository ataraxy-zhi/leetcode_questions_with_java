package com.solution.onequestionperday.may2021.chalkboardxorgame810;

/**
 * @ClassName ChalkboardXORGame
 * @Description 810. Chalkboard XOR Game
 * We are given non-negative integers nums[i] which are written on a chalkboard.  Alice and Bob take turns erasing exactly one number from the chalkboard, with Alice starting first.  If erasing a number causes the bitwise XOR of all the elements of the chalkboard to become 0, then that player loses.  (Also, we'll say the bitwise XOR of one element is that element itself, and the bitwise XOR of no elements is 0.)
 * <p>
 * Also, if any player starts their turn with the bitwise XOR of all the elements of the chalkboard equal to 0, then that player wins.
 * <p>
 * Return True if and only if Alice wins the game, assuming both players play optimally.
 * <p>
 * Example:
 * Input: nums = [1, 1, 2]
 * Output: false
 * Explanation:
 * Alice has two choices: erase 1 or erase 2.
 * If she erases 1, the nums array becomes [1, 2]. The bitwise XOR of all the elements of the chalkboard is 1 XOR 2 = 3. Now Bob can remove any element he wants, because Alice will be the one to erase the last element and she will lose.
 * If Alice erases 2 first, now nums becomes [1, 1]. The bitwise XOR of all the elements of the chalkboard is 1 XOR 1 = 0. Alice will lose.
 * <p>
 * Notes:
 * <p>
 * 1 <= N <= 1000.
 * 0 <= nums[i] <= 2^16.
 * <p>
 * 810. 黑板异或游戏
 * 黑板上写着一个非负整数数组 nums[i] 。Alice 和 Bob 轮流从黑板上擦掉一个数字，Alice 先手。如果擦除一个数字后，剩余的所有数字按位异或运算得出的结果等于 0 的话，当前玩家游戏失败。 (另外，如果只剩一个数字，按位异或运算得到它本身；如果无数字剩余，按位异或运算结果为 0。）
 * <p>
 * 换种说法就是，轮到某个玩家时，如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。
 * <p>
 * 假设两个玩家每步都使用最优解，当且仅当 Alice 获胜时返回 true。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: nums = [1, 1, 2]
 * 输出: false
 * 解释:
 * Alice 有两个选择: 擦掉数字 1 或 2。
 * 如果擦掉 1, 数组变成 [1, 2]。剩余数字按位异或得到 1 XOR 2 = 3。那么 Bob 可以擦掉任意数字，因为 Alice 会成为擦掉最后一个数字的人，她总是会输。
 * 如果 Alice 擦掉 2，那么数组变成[1, 1]。剩余数字按位异或得到 1 XOR 1 = 0。Alice 仍然会输掉游戏。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 * 0 <= nums[i] <= 2^16
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chalkboard-xor-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/5/22 14:22
 */
public class ChalkboardXORGame {
}

class Solution {
    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }
}
