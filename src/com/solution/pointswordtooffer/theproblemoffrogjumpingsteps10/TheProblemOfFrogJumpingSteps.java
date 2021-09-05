package com.solution.pointswordtooffer.theproblemoffrogjumpingsteps10;

/**
 * @ClassName TheProblemOfFrogJumpingSteps
 * @Description 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * 提示：
 * <p>
 * 0 <= n <= 100
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @Author
 * @Date 2021/3/10 15:11
 */
public class TheProblemOfFrogJumpingSteps {
}

/**
 * 迭代
 */
class Solution {
    public int numWays(int n) {
        // n<=1
        if(n<=1){
            return 1;
        }

        // n=2
        if(n==2){
            return 2;
        }

        // n>=3
        int a=1,b=2,c=0;
        for(int i=2;i<n;i++){
            c=(a+b)%1000000007;
            a=b;
            b=c;
        }

        return c;
    }
}