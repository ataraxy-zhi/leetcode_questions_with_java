package com.solution.simple.swapnodesinpairs24;

/**
 * @description: 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例：给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 来源：力扣（LeetCode）链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 解题参考：https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/hua-jie-suan-fa-24-liang-liang-jiao-huan-lian-biao/
 * @author:
 * @date: 2019/12/2 19:39
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = createList(nums);
        ListNode head1 = createList(nums);
        ListNode listNode = swapPairs(head);
        ListNode listNode1 = swapPairs1(head1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }


    //leetcode 非递归解法
    public static ListNode swapPairs(ListNode head) {
        //链表只有一个节点时，直接返回头节点
        if (head == null || head.next == null) {
            return head;
        }

        //生成一个节点作为链表的新头节点
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode temp = newHead;

        //至少要有两个节点供交换
        while (temp.next != null && temp.next.next != null) {
            //start表示所要进行节点交换的位置在前的节点
            ListNode start = temp.next;
            //start表示所要进行节点交换的位置在后的节点
            ListNode end = temp.next.next;

            //后面节点换到前面
            temp.next = end;
            start.next = end.next;
            //前面节点换到后面
            end.next = start;
            temp = start;

        }
        return newHead.next;
    }

    //leetcode 递归解法
    public static ListNode swapPairs1(ListNode head) {
        //递归终止条件：只有一个节点时返回该节点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head.next;
        //head连接已经交换好了了节点（链表）
        head.next = swapPairs(p.next);
        //p连接head（p与head交换了位置的）
        p.next = head;

        return p;
    }

    //生成链表
    public static ListNode createList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            ListNode p = new ListNode(nums[i]);
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = p;
        }

        return head;
    }
}

//链表节点类
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
