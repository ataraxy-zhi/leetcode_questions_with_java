package com.solution.simple.searchinsertposition35;

/**
 * @className: SearchInsertPosition
 * @description:
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author: j
 * @date: 2020/3/20 8:33
 */
public class SearchInsertPosition {

    public static void main(String[] args) {

        int[] nums={1,3,5,6};
        int target=2;
        System.out.println(searchInsert(nums,target));
    }

    public static int searchInsert(int[] nums, int target) {

        if(nums.length==0){
            return 0;
        }

        int low=0;
        int high= nums.length-1;

        while(low<=high){

            int mid=(high+low)/2;

            if(target==nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }

        return low;
    }
}
