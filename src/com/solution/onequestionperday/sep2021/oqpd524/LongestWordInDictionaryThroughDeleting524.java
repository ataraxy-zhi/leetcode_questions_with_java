package com.solution.onequestionperday.sep2021.oqpd524;

import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * <p>
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yi
 * @date 2021/9/14 19:34
 */
public class LongestWordInDictionaryThroughDeleting524 {
}

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        // 长度降序，字典升序
        dictionary.sort((str1, str2) -> {
            if (str1.length() != str2.length()) {
                return str2.length() - str1.length();
            } else {
                return str1.compareTo(str2);
            }
        });

        // 判断
        for (String t : dictionary) {
            if (isSubsequence(t, s)) {
                return t;
            }
        }

        return "";
    }

    // 判断 t 是否 为 s 子序列
    public boolean isSubsequence(String t, String s) {
        int i = 0, j = 0;

        while (i < t.length() && j < s.length()) {
            if (t.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == t.length();
    }
}
