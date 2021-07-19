package com.solution.onequestionperday.july2021.oqpd1838;

import java.util.Arrays;

/**
 * @ClassName Oqpd1838
 * @Description 1838. 最高频元素的频数
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * <p>
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,8,13], k = 5
 * 输出：2
 * 解释：存在多种最优解决方案：
 * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,9,6], k = 2
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 1 <= k <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/7/19 22:54
 */
public class Oqpd1838 {
}

class Solution {
    public int maxFrequency(int[] nums, int k) {
        // 先对数组排序，这样我们只需要对某个数 i 前面的元素进行操作，使得这些元素等于 i 就行
        Arrays.sort(nums);
        int n = nums.length, max = 0, l = 0, r = 0, sum = 0;
        // 维护一个滑动窗口
        while (r < n - 1) {
            // sum 代表的是滑动窗口内的元素和
            sum += nums[r];
            // 对任意一个元素 nums[r + 1]， 如果想让其频数尽可能大地增加，
            // 理所应当先对距离这个数最近且小于它的数操作，随后在往前对元素进行操作
            if ((r - l + 1) * nums[r + 1] - sum <= k) {
                max = Math.max(max, r - l + 1);
            } else {
                //当无法操作r-l+1个数的时候，滑动窗口左端右移一个位置
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return max + 1;
    }
}
