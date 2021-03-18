package com.solution.simple.reverselinkedlist206;

/**
 * 206. Reverse Linked List Given the head of a singly linked list, reverse the
 * list, and return the reversed list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5] Output: [5,4,3,2,1] Example 2:
 * 
 * 
 * Input: head = [1,2] Output: [2,1] Example 3:
 * 
 * Input: head = [] Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is the range [0, 5000]. -5000 <= Node.val <=
 * 5000
 * 
 * 
 * Follow up: A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
 * 
 * 
 * 
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedList {

}

/**
 * 链表
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 迭代
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            // 保存当前节点的下一节点，防止断链
            ListNode temp = cur.next;
            // 翻转
            cur.next = pre;
            // 向后移（遍历）
            pre = cur;
            cur = temp;
        }

        return pre;

    }
}

/**
 * 递归
 */
class Solution2 {
    public ListNode reverseList(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }

        // 递归判断其下一节点（翻转是其原先的下一节点指向它本身）
        ListNode p = reverseList(head.next);
        // 翻转
        head.next.next = head;
        // 避免死循环（看不懂）
        head.next = null;

        return p;

    }
}