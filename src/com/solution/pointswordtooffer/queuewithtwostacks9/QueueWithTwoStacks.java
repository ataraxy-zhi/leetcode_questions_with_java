package com.solution.pointswordtooffer.queuewithtwostacks9;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName QueueWithTwoStacks
 * @Description 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * <p>
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @Author
 * @Date 2021/3/9 16:24
 */
public class QueueWithTwoStacks {
}


class CQueue {
    // 输入栈
    Deque<Integer> inStack;
    // 输出栈
    Deque<Integer> outStack;

    public CQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    // 插入数据进输入栈
    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        // 若输入栈和输出栈都为空则说明队列为空
        if (outStack.isEmpty() && inStack.isEmpty()) {
            return -1;
        } else if (outStack.isEmpty()) {
            // 输出栈不空则弹出其栈顶；否则先将输入栈全部弹出输出栈，再弹出其栈顶
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }
}
