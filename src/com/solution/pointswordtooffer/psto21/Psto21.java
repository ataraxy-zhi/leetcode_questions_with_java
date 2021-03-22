package com.solution.pointswordtooffer.psto21;

/**
 * @ClassName Psto21
 * @Description 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/3/22 9:42
 */
public class Psto21 {
}


class Solution {
    public int[] exchange(int[] nums) {

        int p = 0, q = nums.length - 1;

        while (p < q) {
            if (nums[p] % 2 == 0 && nums[q] % 2 == 1) {
                int temp = nums[p];
                nums[p] = nums[q];
                nums[q] = temp;
                p++;
                q--;
            } else if (nums[p] % 2 == 0 && nums[q] % 2 == 0) {
                q--;
            } else if (nums[p] % 2 == 1 && nums[q] % 2 == 0) {
                p++;
                q--;
            } else {
                p++;
            }

        }

        return nums;
    }
}

/**
 * 优化判断语句
 */
class Solution2 {
    public int[] exchange(int[] nums) {

        int p = 0, q = nums.length - 1;

        while (p < q) {

            while (p < q && nums[p] % 2 == 1) {
                p++;
            }

            while (p < q && nums[q] % 2 == 0) {
                q--;
            }

            int temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
        }

        return nums;
    }
}