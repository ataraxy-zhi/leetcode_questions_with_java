package com.solution.onequestionperday.march2021.spiralmatrixii59;

/**
 * Given a positive integer n, generate an n x n matrix filled with elements
 * from 1 to n2 in spiral order.
 * 
 *  
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3 Output: [[1,2,3],[8,9,4],[7,6,5]] Example 2:
 * 
 * Input: n = 1 Output: [[1]]  
 * 
 * Constraints:
 * 
 * 1 <= n <= 20
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 59. 螺旋矩阵 II 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3 输出：[[1,2,3],[8,9,4],[7,6,5]] 示例 2：
 * 
 * 输入：n = 1 输出：[[1]]
 * 
 * 
 * 提示：
 * 
 * 1 <= n <= 20
 */
public class SpiralMatrixII {

}

/**
 * 设定边界，依次填充
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;

        int num = 0;

        while (num < n * n) {
            // 一直向右填充
            for (int j = left; j <= right; j++) {
                matrix[top][j] = ++num;
            }

            top++;

            // 一直向下填充
            for (int i = top; i <= down; i++) {
                matrix[i][right] = ++num;
            }

            right--;

            // 一直向左填充
            for (int j = right; j >= left; j--) {
                matrix[down][j] = ++num;
            }

            down--;

            // 一直向上填充
            for (int i = down; i >= top; i--) {
                matrix[i][left] = ++num;
            }

            left++;
        }

        return matrix;
    }
}