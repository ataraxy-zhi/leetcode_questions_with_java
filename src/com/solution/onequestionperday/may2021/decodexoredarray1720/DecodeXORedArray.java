package com.solution.onequestionperday.may2021.decodexoredarray1720;

/**
 * @ClassName DecodeXORedArray
 * @Description 1720. Decode XORed Array
 * There is a hidden integer array arr that consists of n non-negative integers.
 * <p>
 * It was encoded into another integer array encoded of length n - 1, such that encoded[i] = arr[i] XOR arr[i + 1]. For example, if arr = [1,0,2,1], then encoded = [1,2,3].
 * <p>
 * You are given the encoded array. You are also given an integer first, that is the first element of arr, i.e. arr[0].
 * <p>
 * Return the original array arr. It can be proved that the answer exists and is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: encoded = [1,2,3], first = 1
 * Output: [1,0,2,1]
 * Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * Example 2:
 * <p>
 * Input: encoded = [6,2,7,3], first = 4
 * Output: [4,2,0,7,4]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 104
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 105
 * 0 <= first <= 105
 * <p>
 * 1720. 解码异或后的数组
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * <p>
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * <p>
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * <p>
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * 示例 2：
 * <p>
 * 输入：encoded = [6,2,7,3], first = 4
 * 输出：[4,2,0,7,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 104
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 105
 * 0 <= first <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/5/6 19:23
 */
public class DecodeXORedArray {
}

class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] result = new int[n + 1];

        result[0] = first;

        for (int i = 1; i < n + 1; i++) {
            result[i] = encoded[i - 1] ^ result[i - 1];
        }

        return result;
    }
}