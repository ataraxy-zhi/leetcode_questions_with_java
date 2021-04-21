package com.solution.onequestionperday.april2021.decodeways91;

/**
 * @ClassName DecodeWays
 * @Description 91. Decode Ways
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 * <p>
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * <p>
 * Given a string s containing only digits, return the number of ways to decode it.
 * <p>
 * The answer is guaranteed to fit in a 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * Example 3:
 * <p>
 * Input: s = "0"
 * Output: 0
 * Explanation: There is no character that is mapped to a number starting with 0.
 * The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
 * Hence, there are no valid ways to decode this since all digits need to be mapped.
 * Example 4:
 * <p>
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 * <p>
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 * <p>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 * <p>
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 示例 4：
 * <p>
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/4/21 17:09
 */
public class DecodeWays {
}

/**
 * 动态规划
 */
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c=f[i]
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }
}
