package com.solution.onequestionperday.march2021.reverselinkedlistii92;

/**
 * 92. Reverse Linked List II Given the head of a singly linked list and two
 * integers left and right where left <= right, reverse the nodes of the list
 * from position left to position right, and return the reversed list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], left = 2, right = 4 Output: [1,4,3,2,5] Example 2:
 * 
 * Input: head = [5], left = 1, right = 1 Output: [5]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is n. 1 <= n <= 500 -500 <= Node.val <= 500 1
 * <= left <= right <= n
 * 
 * 
 * Follow up: Could you do it in one pass?
 * 
 * 
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 
 * 说明: 1 ≤ m ≤ n ≤ 链表长度。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4 输出: 1->4->3->2->5->NULL
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedListII {

}

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

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}