package com.solution.pointswordtooffer.printinglinkedlistfromendtoend6;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName PrintingLinkedListFromEndToEnd
 * @Description 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @Author
 * @Date 2021/3/9 14:44
 */
public class PrintingLinkedListFromEndToEnd {
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


// 借助栈
class Solution {
    public int[] reversePrint(ListNode head) {

        Deque<Integer> stack = new LinkedList<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] result = new int[stack.size()];
        int n = stack.size();

        for (int i = 0; i < n; i++) {
            result[i] = stack.pop();
        }

        return result;

    }
}