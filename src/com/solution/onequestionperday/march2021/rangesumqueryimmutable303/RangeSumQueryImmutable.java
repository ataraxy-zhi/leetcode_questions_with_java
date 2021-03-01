package com.solution.onequestionperday.march2021.rangesumqueryimmutable303;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int i, int j) Return the sum of the elements of the nums array in the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j]))
 *  
 *
 * Example 1:
 *
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 *
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *  
 *
 * Constraints:
 *
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * At most 104 calls will be made to sumRange.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 1st
 */
public class RangeSumQueryImmutable {
    /**
     * 暴力法
     */
    static class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            this.nums=nums;
        }

        public int sumRange(int i, int j) {
            int sum=0;

            for(int index=i;index<=j;index++){
                sum+=nums[index];
            }

            return sum;
        }
    }

    /**
     * 前缀和（考虑到题目会计算多次，所以采用计算前缀和的1方式避免重复计算）
     */
    static class NumArray2 {

        int[] preSum;

        public NumArray2(int[] nums) {
            int length=nums.length;
            preSum =new int[length+1];
            for(int i=0;i<length;i++){
                preSum[i+1]=preSum[i]+nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return preSum[j+1]-preSum[i];
        }
    }
}
