package com.solution.onequestionperday.march2021.evaluatereversepolishnotation150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 150. Evaluate Reverse Polish Notation 
 * Evaluate the value of an arithmetic
 * expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, and /. Each operand may be an integer or another
 * expression.
 * 
 * Note that division between two integers should truncate toward zero.
 * 
 * It is guaranteed that the given RPN expression is always valid. That means
 * the expression would always evaluate to a result, and there will not be any
 * division by zero operation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: tokens = ["2","1","+","3","*"] Output: 9 Explanation: ((2 + 1) * 3) =
 * 9 Example 2:
 * 
 * Input: tokens = ["4","13","5","/","+"] Output: 6 Explanation: (4 + (13 / 5))
 * = 6 Example 3:
 * 
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22 Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = ((10 * (6 /
 * (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 =
 * (0 + 17) + 5 = 17 + 5 = 22
 * 
 * 
 * Constraints:
 * 
 * 1 <= tokens.length <= 104 tokens[i] is either an operator: "+", "-", "*", or
 * "/", or an integer in the range [-200, 200].
 * 
 * 
 * 根据 逆波兰表示法，求表达式的值。
 * 
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 
 *  
 * 
 * 说明：
 * 
 * 整数除法只保留整数部分。 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。  
 * 
 * 示例 1：
 * 
 * 输入：tokens = ["2","1","+","3","*"] 输出：9 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 * 
 * 输入：tokens = ["4","13","5","/","+"] 输出：6 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) =
 * 6 示例 3：
 * 
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"] 输出：22
 * 解释： 该算式转化为常见的中缀算术表达式为： ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = ((10 * (6 /
 * (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 =
 * (0 + 17) + 5 = 17 + 5 = 22  
 * 
 * 提示：
 * 
 * 1 <= tokens.length <= 104 tokens[i] 要么是一个算符（"+"、"-"、"*" 或 "/"），要么是一个在范围
 * [-200, 200] 内的整数  
 * 
 * 逆波兰表达式：
 * 
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * 
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 +
 * ) * ) 。 逆波兰表达式主要有以下两个优点：
 * 
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EvaluateReversePolishNotation {

}

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = tokens.length;
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
