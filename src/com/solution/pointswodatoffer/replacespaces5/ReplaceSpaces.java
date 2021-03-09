package com.solution.pointswodatoffer.replacespaces5;

/**
 * @ClassName ReplaceSpaces
 * @Description 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @Author
 * @Date 2021/3/8 18:04
 */
public class ReplaceSpaces {
}

class Solution {
    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                result.append("%20");
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
