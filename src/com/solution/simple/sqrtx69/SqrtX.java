package com.solution.simple.sqrtx69;

/**
 * @className: SqrtX
 * @description: 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: j
 * @date: 2020/4/13 8:45
 */
public class SqrtX {

    public static void main(String[] args) {

        System.out.println(mySqrt(5));

    }

    public static int mySqrt(int x) {

        //迭代初值一般取x/2
        double a0 = x / 2.0, a1 = (a0 + x / a0) / 2.0;

        //精度越大越好，这里取1.0e-10
        while (Math.abs(a1 - a0) > 1.0e-10) {
            a0 = a1;
            a1 = (a0 + x / a0) / 2.0;
        }

        //取a1和a0均可
        return (int)a1;

    }
}
