package com.solution.pointswordtooffer.pstto21;

/**
 * @ClassName Psto21
 * @Description
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