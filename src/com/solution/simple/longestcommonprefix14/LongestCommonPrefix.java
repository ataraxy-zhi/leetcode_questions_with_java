package com.solution.simple.longestcommonprefix14;

/**
 * @className: LongestCommonPrefix
 * @description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: j
 * @date: 2020/3/3 15:03
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        //String[] strs={"flower","flow","flight"};
        String[] strs={"abca","aba","aaab"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {

        //输入为空
        if(strs.length == 0){
            return "";
        }

        String result=strs[0];
        //公共前缀的长度
        int index=0;
        //判断两个字符串的首字符是否相等 默认不等   为了保证所求出的前缀是从首部开始的
        boolean flag=false;

        for (int i = 1; i <strs.length ; i++) {

            for (int j = 0; j <result.length() && j<strs[i].length() ; j++) {
                if(result.charAt(j)==strs[i].charAt(j)){
                    if(!flag){
                        index++;
                    }
                }else {
                    flag=true;
                }
            }

            //更新前缀
            result=result.substring(0,index);
            //注意相应的判断变量也要更新
            index=0;
            flag=false;

        }
        return result;
    }
}
