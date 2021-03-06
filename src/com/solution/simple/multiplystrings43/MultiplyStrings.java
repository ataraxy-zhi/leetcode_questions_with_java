package com.solution.simple.multiplystrings43;

/**
 * @description: 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例 1: 输入: num1 = "2", num2 = "3" 输出: "6";示例 2: 输入: num1 = "123", num2 = "456"  输出: "56088"
 * 说明：num1 和 num2 的长度小于110。num1 和 num2 只包含数字 0-9。num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 来源：力扣（LeetCode）  链接：https://leetcode-cn.com/problems/multiply-strings
 * @author: j
 * @date: 2019/12/3 20:15
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "45";
        String result = multiply(num1, num2);
        System.out.println(result);

    }

    public static String multiply(String num1, String num2) {
        //乘数为0返回0
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        //结果最大位数为num1.length() + num2.length()
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            //得到第i个位置字符所代表的数字，这里的计算是用ASCII码
            int n1 = num1.charAt(i) - '0';

            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                //保存结果的个位,注意叠加
                res[i + j + 1] = sum % 10;
                //保存结果的十位（也就是进位），注意叠加
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            //由于最高位的进位即使是0也保存下来了的，故要去除
            if (i == 0 && res[i] == 0) {
                continue;
            }
            result.append(res[i]);
        }

        return result.toString();
    }


}


