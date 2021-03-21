package com.solution.onequestionperday.march2021.setmatrixzeroes73;

/**
 * 73. Set Matrix Zeroes Given an m x n matrix. If an element is 0, set its
 * entire row and column to 0. Do it in-place.
 * 
 * Follow up:
 * 
 * A straight forward solution using O(mn) space is probably a bad idea. A
 * simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]] Output: [[1,0,1],[0,0,0],[1,0,1]]
 * Example 2:
 * 
 * 
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]] Output:
 * [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 * 
 * Constraints:
 * 
 * m == matrix.length n == matrix[0].length 1 <= m, n <= 200 -231 <=
 * matrix[i][j] <= 231 - 1
 * 
 * 
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 
 * 示例 1:
 * 
 * 输入: [   [1,1,1],   [1,0,1],   [1,1,1] ] 输出: [   [1,0,1],   [0,0,0],   [1,0,1]
 * ] 示例 2:
 * 
 * 输入: [   [0,1,2,0],   [3,4,5,2],   [1,3,1,5] ] 输出: [   [0,0,0,0],   [0,4,5,0],
 *   [0,3,1,0] ] 进阶:
 * 
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。 一个简单的改进方案是使用 O(m + n)
 * 的额外空间，但这仍然不是最好的解决方案。 你能想出一个常数空间的解决方案吗？
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class SetMatrixZeroes {

}

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 标记第一行、第一列是否出现 0
        boolean flagCol0 = false, flagRow0 = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }

        // 根据其他行列的情况推断第一行列是否要将某些元素置为 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // 再以第一行列置为 0 的情形反推其他行列元素为 0 的情况
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 根据最初判断第一行列是否本身含有 0 来更新第一行列的值
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
