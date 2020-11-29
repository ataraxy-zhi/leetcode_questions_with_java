package com.solution.simple.plusone66;

/**
 * @className: PlusOne
 * @description:
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: j
 * @date: 2020/4/3 20:26
 */
public class PlusOne {

    public static void main(String[] args) {

        int[] nums={1,2,3};
        int[] results=plusOne(nums);

        for (int result : results) {
            System.out.println(result);
        }

    }

    public static int[] plusOne(int[] digits) {

        //结果位数比原数组大
        int[] temps=new int[digits.length+1];
        //结果位数比原数组小
        int[] results=new int[digits.length];
        //进位
        int carry=1;

        for(int i=digits.length-1;i>=0;i--){
            temps[i]=(digits[i]+carry)%10;
            carry=(digits[i]+carry)/10;
        }

        //结果位数比原数组大
        if(carry>0){
            temps[0]=carry;
            return temps;
        }

        //复制数组
        System.arraycopy(temps, 0, results, 0, temps.length - 1);

        return results;


    }
}
