package com.solution.simple.permutations46;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: j
 * @date: 2019/12/8 18:18
 */
public class Permutation {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        permutation(nums, 0, nums.length, result);
        return result;
    }


    //递归函数(求解全排列)，len表示数组长度，first表示第一个数的位置，result为最终结果
    private void permutation(int[] nums,int first,  int len,List<List<Integer>> result) {
        //此时表示已交换除第一数之外的所有数
        if (first == len - 1) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                tempList.add(nums[i]);
            }
            result.add(tempList);
            return;
        }

        //递归调用
        permutation(nums, first + 1, len, result);

        for (int i = first + 1; i < len; i++) {
            // 将除第一位的数依次与第一位数交换
            swap(nums, first, i);
            permutation(nums, first + 1, len, result);
            //再交换回来，避免重复情况
            swap(nums, first, i);
        }
    }

    //交换数组某两个位置的数
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
