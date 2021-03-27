package com.solution.onequestionperday.march2021.rotatelist61;

/**
 * @ClassName RotateList
 * @Description 61. Rotate List
 * Given the head of a linked list, rotate the list to the right by k places.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * <p>
 * <p>
 * 61. 旋转链表
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/3/27 8:53
 */
public class RotateList {
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
 * 循环移动，考虑将链表变为环
 * 对于快慢指针，应单独遍历先让快指针先走相应的步数
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 空表、单节点、移动次数为 0
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 求长度
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }

        // 将链表变为环
        cur.next = head;

        // 简化 k
        k = k % len;

        // 寻找最终结果的尾节点
        for (int i = 1; i < len - k; i++) {
            head = head.next;
        }

        // 新的首节点为尾节点的下一节点
        ListNode newHead = head.next;

        // 断链
        head.next = null;

        return newHead;
    }
}