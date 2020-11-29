package com.solution.simple.longestsubstringwithoutrepeatingcharacters3;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: j
 * @date: 2019/12/15 8:21
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {

        if(" ".equals(s)){
            return 1;
        }

        //结果
        int result=0;

        //使用HashMap
        Map<Character, Integer> map = new HashMap<>();

        //i、j分别代表窗口的左右两端，移动j，在出现重复字符的时候再考虑移动i的位置
        for (int j = 0, i = 0; j < s.length(); j++) {
            //判断未放入hashmap的字符是否与已放入的重复
            if (map.containsKey(s.charAt(j))) {
                /**
                 * 重复，需考虑移动i的位置
                 * 为保证i是一直往右移的，i的值就取重复字符（新字符）的位置索引加1与i之前值的最大值,而不是直接取重复字符的位置索引加1
                 * 因为在一个字符串里面可能前后有多个重复的不同字符（如abcdbefa），而窗口的移动的趋势始终是向右的
                 * 这里位置索引加1是为了避开重复字符，肯定要从被重复的字符的下一个位置开始
                 */

                i = Math.max(map.get(s.charAt(j))+1, i);
            }

            //求最长的无重复字符长度,j - i + 1为窗口长度
            result = Math.max(result, j - i + 1);

            //放入hashmap字符的值相应的为其位置索引j,另外在hashmap中放入相同的键时，其值会覆盖原有的
            //所以对于重复字符，hashmap不会新放入，而是将以前的那个值更新即可
            map.put(s.charAt(j), j);
        }


        return result;
    }

    //判断字符串中是否含有重复字符
    public static boolean duplicateCharacters(String s){
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    return true;
                }
            }
        }

        return false;
    }


}
