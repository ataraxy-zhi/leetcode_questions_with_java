package com.solution.onequestionperday.april2023;

import java.util.Arrays;

/**
 * 1040. 移动石子直到连续 II
 * 提示
 * 中等
 * 193
 * 相关企业
 * 在一个长度 无限 的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作 端点石子 。
 * <p>
 * 每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。
 * <p>
 * 值得注意的是，如果石子像 stones = [1,2,5] 这样，你将 无法 移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3），该石子都仍然会是端点石子。
 * <p>
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * <p>
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,4,9]
 * 输出：[1,2]
 * 解释：
 * 我们可以移动一次，4 -> 8，游戏结束。
 * 或者，我们可以移动两次 9 -> 5，4 -> 6，游戏结束。
 * 示例 2：
 * <p>
 * 输入：[6,5,4,3,10]
 * 输出：[2,3]
 * 解释：
 * 我们可以移动 3 -> 8，接着是 10 -> 7，游戏结束。
 * 或者，我们可以移动 3 -> 7, 4 -> 8, 5 -> 9，游戏结束。
 * 注意，我们无法进行 10 -> 2 这样的移动来结束游戏，因为这是不合要求的移动。
 * 示例 3：
 * <p>
 * 输入：[100,101,104,102,103]
 * 输出：[0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= stones.length <= 10^4
 * 1 <= stones[i] <= 10^9
 * stones[i] 的值各不相同。
 */
public class MovingStonesUntilConsecutiveII1040 {
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        // 石头最大可放置空间=初始左右两端还未占用的空间 - min(左边第1,2颗之间空隙,右边第1,2颗之间空隙)
        int max = stones[n - 1] - stones[0] + 1 - n;
        max -= Math.min(stones[n - 1] - stones[n - 2] - 1, stones[1] - stones[0] - 1);
        // 石头最小可放置空间=n大小连续空间里初始有最多颗石头的情况(滑动n大小窗口)
        int min = max;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && stones[j] < stones[i] + n) {
                j++;
            }
            // 需要往stones[i]~stones[j]里移多少颗石头
            int cost = n - (j - i);
            // 考虑特殊情况3,4,5,6,10,此时不能移10->7,而必须移3->8,10->7,故为两次
            if (j - 1 - i == n - 2 && stones[j - 1] - stones[i] == n - 2) {
                cost = 2;
            }
            min = Math.min(min, cost);
        }
        return new int[]{min, max};
    }
}
