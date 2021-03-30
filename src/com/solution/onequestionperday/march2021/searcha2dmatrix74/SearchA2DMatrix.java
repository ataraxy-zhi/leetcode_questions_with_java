package com.solution.onequestionperday.march2021.searcha2dmatrix74;

/**
 * @ClassName SearchA2DMatrix
 * @Description 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * <p>
 * <p>
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/3/30 9:47
 */
public class SearchA2DMatrix {
}

/**
 * 从右上角或左下角开始查找
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 1 && n == 1) {
            return matrix[0][0] == target;
        }

        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}

/**
 * 两次二分查找
 */
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    /**
     * 找到最后一个不大于目标值的元素所在的行
     * @param matrix
     * @param target
     * @return row
     */
    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}


//class Solution2 {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        if (m == 1 && n == 1) {
//            return matrix[0][0] == target;
//        }
//
//        int row = 0;
//        // int col=0;
//
//        // 第一次二分寻找目标可能所在的行
//        int rowLow = 0, rowHigh = m - 1;
//        while (rowLow <= rowHigh) {
//            // int mid = (rowLow + rowHigh) / 2;
//            int mid = (rowHigh - rowLow) / 2 + rowLow;
//            if (matrix[mid][0] == target) {
//                return true;
//            } else if (matrix[mid][0] < target) {
//                rowLow = mid + 1;
//            } else {
//                rowHigh = mid - 1;
//            }
//        }
//        row = rowLow;
//
//        // 第二次二分寻找目标可能所在的列
//        int colLow = 0, colHigh = n - 1;
//        while (colLow <= colHigh) {
//            int mid = (colLow + colHigh) / 2;
//            if (matrix[row][mid] == target) {
//                return true;
//            } else if (matrix[row][mid] < target) {
//                colLow = mid + 1;
//            } else {
//                colHigh = mid - 1;
//            }
//        }
//
//        return false;
//    }
//}
