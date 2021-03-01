package com.solution.topinterviewquestions.mergesortedarray88;

/**
 * 88. Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 *
 *
 * Constraints:
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 *
 *
 *
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
public class MergeSortedArray {

    static class Solution {
        /**
         * 借助辅助数组及下标，一一比较赋值
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {

            int[] nums=new int[m+n];
            int k=0;
            int i=0,j=0;

            while(i<m && j<n){
                if(nums1[i]<=nums2[j]){
                    nums[k]=nums1[i];
                    k++;
                    i++;
                }else{
                    nums[k]=nums2[j];
                    k++;
                    j++;
                }
            }

            while(i<m){
                nums[k]=nums1[i];
                k++;
                i++;
            }

            while(j<n){
                nums[k]=nums2[j];
                k++;
                j++;
            }

            System.arraycopy(nums, 0, nums1, 0, m + n);

        }



        /**
         * 借助辅助数组及指针，从后面比较赋值   简化代码
         */
        public void merge2(int[] nums1, int m, int[] nums2, int n) {

            int p1 = m - 1;
            int p2 = n - 1;
            int p = m + n - 1;

            /*while ((p1 >= 0) && (p2 >= 0)){
                nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
            }*/

            while(p1>=0 && p2>=0){
                if(nums1[p1] < nums2[p2]){
                    nums1[p]=nums2[p2];
                    p--;
                    p2--;
                }else {
                    nums1[p]=nums1[p1];
                    p--;
                    p1--;
                }
            }

            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);


        }
    }
}
