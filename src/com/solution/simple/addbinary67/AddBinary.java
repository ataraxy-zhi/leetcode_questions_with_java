package com.solution.simple.addbinary67;

/**
 * @className: AddBinary
 * @description:
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: j
 * @date: 2020/4/3 21:46
 */
public class AddBinary {

    public static void main(String[] args) {

        String str1="110";
        String str2="01";
        System.out.println(addBinary(str1,str2));
    }

    public static String addBinary(String a, String b) {

        if(a.length()==0){
            return b;
        }

        if(b.length()==0){
            return a;
        }

        //按照一般习惯：大数在前
        String temps;
        if(a.length()<b.length()){
            temps=a;
            a=b;
            b=temps;
        }

        //数位本位和
        int sum=0;

        //数位进位
        int carry=0;

        //这里使用StringBuilder而不使用String，是为了便于添加数据
        StringBuilder results=new StringBuilder();

        for(int i=a.length()-1,j=b.length()-1;i>=0 || j>=0;i--,j--){
            //数位之和
            int sumTemp=0;

            if(j>=0){
                sumTemp+=b.charAt(j)-'0';
            }

            sumTemp+=a.charAt(i)-'0';

            sum=(sumTemp+carry)%2;
            carry=(sumTemp+carry)/2;

            results.append(sum);

        }

        //最高位进位不为0
        if(carry>0){
            results.append(carry);
        }

        //注意计算是从右往左，返回时用从左往右，并且需转换为字符串的形式
        return results.reverse().toString();
    }
}
