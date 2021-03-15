package com.solution.onequestionperday.march2021.spiralmatrix54;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SpiralMatrix
 * @Description 54. Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * https://leetcode-cn.com/problems/spiral-matrix/
 * @Author
 * @Date 2021/3/15 9:27
 */
public class SpiralMatrix {
}

/**
 * 处理边界，边界交叉时终止
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            // 一直向右遍历
            for (int j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }

            // 修改上边界
            top += 1;
            if (top > down) {
                break;
            }

            // 一直向下遍历
            for (int i = top; i <= down; i++) {
                list.add(matrix[i][right]);
            }

            // 修改右边界
            right -= 1;
            if (right < left) {
                break;
            }

            // 一直向左遍历
            for (int j = right; j >= left; j--) {
                list.add(matrix[down][j]);
            }

            // 修改下边界
            down -= 1;
            if (down < top) {
                break;
            }

            // 一直向上遍历
            for (int i = down; i >= top; i--) {
                list.add(matrix[i][left]);
            }

            // 修改左边界
            left += 1;
            if (left > right) {
                break;
            }

        }

        return list;

    }
}