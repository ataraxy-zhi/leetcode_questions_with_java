package com.solution.pointswodatoffer.searchingintwodimensionalarray4;

/**
 * @ClassName SearchingInTwoDimensionalArray4
 * @Description 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * <p>
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @Author
 * @Date 2021/3/8 16:36
 */
public class SearchingInTwoDimensionalArray {


}

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 特殊情况
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0, j = m - 1;

        // 从右上角开始判断
        while (i <= n - 1 && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
