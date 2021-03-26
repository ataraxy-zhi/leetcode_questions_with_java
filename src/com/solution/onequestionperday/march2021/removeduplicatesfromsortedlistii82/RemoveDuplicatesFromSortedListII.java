package com.solution.onequestionperday.march2021.removeduplicatesfromsortedlistii82;

/**
 * @ClassName RemoveDuplicatesFromSortedListII
 * @Description 82. Remove Duplicates from Sorted List II
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 * <p>
 * <p>
 * 82. 删除排序链表中的重复元素 II
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/3/25 8:22
 */
public class RemoveDuplicatesFromSortedListII {
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

/**
 * 定义头节点
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        }

        // 有可能会删除第一个节点（头指针），所以事先定义一个头节点
        ListNode p = new ListNode(0, head);
        ListNode cur = p;

        while (cur.next != null && cur.next.next != null) {
            // 有重复
            if (cur.next.val == cur.next.next.val) {
                // 保存重复节点中第一个的值（后续会删除该节点）
                int x = cur.next.val;
                // 删除所有与第一个（指的是相同节点排在前面第一个的）重复的节点（包括其本身）
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                // 无重复则判断下一个

                cur = cur.next;
            }
        }

        return p.next;
    }
}