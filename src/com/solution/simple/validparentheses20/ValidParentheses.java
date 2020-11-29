package com.solution.simple.validparentheses20;

import java.util.Stack;

/**
 * @className: ValidParentheses
 * @description:
 * @author: j
 * @date: 2020/3/10 15:41
 */
public class ValidParentheses {

    public static void main(String[] args) {

        //String s="()[]{}";
        String s="(]";
        boolean judge=isValid(s);
        System.out.println(judge);

    }

    public static boolean isValid(String s) {

        //输入为空
        if(s==null || s.length()==0){
            return true;
        }

        //奇数个括号肯定不满足
        if(s.length()%2!=0){
            return false;
        }

        //利用栈来保存括号
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i <s.length() ; i++) {
            //左括号才入栈
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else {
                //若栈为空 说明第一个为右括号 不行
                if(stack.size()==0){
                    return false;
                }else {
                    if(stack.peek()=='('){
                        if(s.charAt(i)!=')'){
                            return false;
                        }else {
                            stack.pop();
                        }
                    }else if(stack.peek()=='['){
                        if(s.charAt(i)!=']'){
                            return false;
                        }else {
                            stack.pop();
                        }
                    }else if(stack.peek()=='{'){
                        if(s.charAt(i)!='}'){
                            return false;
                        }else {
                            stack.pop();
                        }
                    }else {
                        return false;
                    }
                }
            }

        }

        //由于要一一匹配，故最终栈为空
        return stack.empty();

        /*for (int i = s.length()/2; i <s.length() ; i++) {
            if(stack.peek()=='('){
                if(s.charAt(i)!=')'){
                    return false;
                }else {
                    stack.pop();
                }
            }else if(stack.peek()=='['){
                if(s.charAt(i)!=']'){
                    return false;
                }else {
                    stack.pop();
                }
            }else if(stack.peek()=='{'){
                if(s.charAt(i)!='}'){
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                return false;
            }

        }*/

        //return true;

    }
}
