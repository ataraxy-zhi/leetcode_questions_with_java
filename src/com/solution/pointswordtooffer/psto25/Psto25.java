package com.solution.pointswordtooffer.psto25;

/**
 * @ClassName Psto25
 * @Description 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 * <p>
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/3/22 10:05
 */
public class Psto25 {
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode list = new ListNode(0);
        ListNode head = list;

        while (l1 != null && l2 != null) {
            ListNode temp;
            if (l1.val < l2.val) {
                temp = new ListNode(l1.val);
                list.next = temp;
                l1 = l1.next;
            } else {
                temp = new ListNode(l2.val);
                list.next = temp;
                l2 = l2.next;
            }
            list = list.next;
        }

        while (l1 != null) {
            list.next = new ListNode(l1.val);
            l1 = l1.next;
            list = list.next;
        }

        while (l2 != null) {
            list.next = new ListNode(l2.val);
            l2 = l2.next;
            list = list.next;
        }

        return head.next;

    }
}

/**
 * 优化代码，不用生成新节点，节省空间
 */
class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode list = new ListNode(0);
        ListNode head = list;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                list.next = l1;
                l1 = l1.next;
            } else {
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }

//        if (l1 != null) {
//            list.next = l1;
//        }
//
//        if (l2 != null) {
//            list.next = l2;
//        }

        list.next = l1 != null ? l1 : l2;

        return head.next;

    }
}