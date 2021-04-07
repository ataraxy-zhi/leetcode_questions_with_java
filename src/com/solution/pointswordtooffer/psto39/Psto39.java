package com.solution.pointswordtooffer.psto39;

/**
 * @ClassName Psto39
 * @Description 剑指 Offer 39. 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 *  
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 50000
 * <p>
 *  
 * <p>
 * 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/4/7 9:24
 */
public class Psto39 {
}

/**
 * 摩尔投票
 */
class Solution {
    public int majorityElement(int[] num) {
        int major = num[0];
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                //前面都消完了，再重新赋值
                count++;
                major = num[i];
            } else if (major == num[i]) {
                //自己人，count就加1
                count++;
            } else {
                //不是自己人就同归于尽，消掉一个
                count--;
            }
        }
        return major;
    }

}