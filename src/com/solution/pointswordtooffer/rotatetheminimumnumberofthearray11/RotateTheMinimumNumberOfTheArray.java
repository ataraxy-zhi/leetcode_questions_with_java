package com.solution.pointswordtooffer.rotatetheminimumnumberofthearray11;

/**
 * @ClassName RotateTheMinimumNumberOfTheArray
 * @Description 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @Author
 * @Date 2021/3/10 16:19
 */
public class RotateTheMinimumNumberOfTheArray {
}

/*
class Solution {
    public int minArray(int[] numbers) {

        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]>numbers[i+1]){
                return numbers[i+1];
            }
        }

        return numbers[0];

    }
}*/


class Solution {
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;

        while (high > low) {
            int mid = (low + high) / 2;

            // 中间元素大于等于末尾元素，说明最小值在后半区（不包括中间元素）
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else if (numbers[mid] < numbers[high]) {
                // 中间元素小于末尾元素，说明最小值在前半区（包括中间元素）

                high = mid;
            } else {
                // 中间元素等于末尾元素，说明最小值在前面，应该缩小搜索空间

                high--;
            }
        }

        return numbers[low];
    }
}