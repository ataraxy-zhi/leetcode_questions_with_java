package com.solution.topinterviewquestions.countandsay38;

/**
 * 38. Count and Say
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
 * <p>
 * For example, the saying and conversion for digit string "3322251":
 * <p>
 * <p>
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 * Example 2:
 * <p>
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 30
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 38. 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 * <p>
 * 例如，数字字符串 "3322251" 的描述如下图：
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出："1"
 * 解释：这是一个基本样例。
 * 示例 2：
 * <p>
 * 输入：n = 4
 * 输出："1211"
 * 解释：
 * countAndSay(1) = "1"
 * countAndSay(2) = 读 "1" = 一 个 1 = "11"
 * countAndSay(3) = 读 "11" = 二 个 1 = "21"
 * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 30
 */
public class CountAndSay {
    /**
     * 递归
     */
    static class Solution {
        //层层递进想到递归
        public String countAndSay(int n) {
            //递归第一件事, 递归结束条件
            if (n == 1) {
                return "1";
            }

            String str = countAndSay(n - 1); //上一轮的输出是是下一轮的输入
            StringBuilder ans = new StringBuilder(); //存放当前轮答案, 要用StringBuffer, String如果改变, 底层是复制效率很低
            int len = str.length();

            /*
             * 递归代码最神的地方, 一个循环可以展现出n个嵌套for循环的作用, 可以好好体会
             * 这里的算法在初级算法Lc中经常用到, 当与前一个元素不一样时触发函数
             * 注意从1开始是为了方便对比, 相应的长度也+1方便对比
             **/
            int start = 0; //记录开始下标
            for (int i = 1; i < len + 1; i++) {
                //最后一个元素单独处理
                if (i == len) {
                    ans.append(i - start).append(str.charAt(start));
                } else if (str.charAt(i) != str.charAt(start)) {  //元素改变触发函数
                    ans.append(i - start).append(str.charAt(start));
                    start = i; //更新起始下标
                }
            }


            return ans.toString(); //StringBuffer记得要转化为String类型
        }

    }


    /**
     * 循环
     */
    static class Solution2 {
        public String countAndSay(int n) {
            StringBuilder result = new StringBuilder();
            result.append(1);

            for (int i = 1; i < n; i++) {
                // 记录当前行的字符串
                StringBuilder s = new StringBuilder();
                // 记录每个数字的开始索引
                int start = 0;

                for (int j = 1; j < result.length(); j++) {
                    // 当数字发生改变时执行
                    if (result.charAt(j) != result.charAt(start)) {
                        s.append(j - start).append(result.charAt(start));
                        start = j;
                    }
                }

                // 字符串最后一个数字
                s.append(result.length() - start).append(result.charAt(start));
                result = s;
            }

            return result.toString();
        }
    }
}
