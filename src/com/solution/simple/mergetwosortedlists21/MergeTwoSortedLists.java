package com.solution.simple.mergetwosortedlists21;

/**
 * @className: MergeTwoSortedLists
 * @description:
 * @author: j
 * @date: 2020/3/16 8:49
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {



    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //l2为空，直接返回l1
        if(l2==null){
            return l1;
        }

        //l1为空，直接返回l2
        if(l1==null ){
            return l2;
        }

        //目标链表头节点  引入中间量temp，是因为在程序运行过程中头节点一直在改变
        ListNode temp=new ListNode(-1);
        ListNode result = temp;

        //将l1和l2中较大的节点依次链接到目标节点中去
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                temp.next=l2;
                l2=l2.next;
            }else {
                temp.next=l1;
                l1=l1.next;
            }

            temp=temp.next;
        }

        //l1长度大于l2
        if (l1!=null){
            temp.next=l1;
        }

        //l2长度大于l1
        if (l2!=null){
            temp.next=l2;
        }

        //不能直接返回result,因为result的原始头节点的值是我们自己创造的，要舍去
        return result.next;

    }


    public void printNode(ListNode l){
        while(l.next!=null){
            System.out.println(l.val);
        }
    }
}

//链表节点
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }
}

