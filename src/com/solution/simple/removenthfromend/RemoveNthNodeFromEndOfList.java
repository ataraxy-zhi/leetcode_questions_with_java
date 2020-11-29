package com.solution.simple.removenthfromend;

/**
 * @description:
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 示例：给定一个链表: 1->2->3->4->5, 和 n = 2.当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：给定的 n 保证是有效的。 进阶：你能尝试使用一趟扫描实现吗？ 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 解题参考源码：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/hua-jie-suan-fa-19-shan-chu-lian-biao-de-dao-shu-d/
 * @author:
 * @date: 2019/11/29 10:16
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        ListNode head = createList(nums);
        ListNode listNode = removeNthFromEnd(head, 2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    
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

    // leetcode
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // p为快指针，让p先走n步（边走并判断链表长度）
        ListNode p = head;

        // p所经过链表长度
        int len;
        for (len = 0; len < n; len++) {
            p = p.next;
            if (p == null) {
                break;
            }
        }

        // 链表长度为n时，删除头结点,返回head.next（null）
        if (len == n - 1) {
            return head.next;
        }

        // 链表长度小于n，则返回头节点
        if (len < n - 1) {
            return head;
        }

        // q为慢指针，当p走了n步后，p再出发
        ListNode q = head;

        // 此时链表长度至少为n+1,且p正好指示第n+1个节点
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;

        return head;
    }
}

// 在java中定义链表节点类
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
