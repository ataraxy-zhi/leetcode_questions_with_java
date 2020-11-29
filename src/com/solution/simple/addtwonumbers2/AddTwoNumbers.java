package com.solution.simple.addtwonumbers2;

/**
 * @description:
 * @author: j
 * @date: 2019/12/13 17:22
 */
public class AddTwoNumbers {
    public static void main(String[] args) {


    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //结果头节点
        ListNode result=new ListNode(0);

        ListNode p=result;
        
        int carry=0;

        while(l1!=null || l2!=null){

            int l1Val;
            int l2Val;

            //将两个链表设置成相同长度，对缺少位置的数直接添0即可
            if(l1==null){
                l1Val=0;
            }else {
                l1Val=l1.val;
            }

            //将两个链表设置成相同长度，对缺少位置的数直接添0即可
            if(l2==null){
                l2Val=0;
            }else {
                l2Val=l2.val;
            }

            int sum=l1Val+l2Val+carry;
            carry=sum/10;

            //sum%10表示本位
            p.next=new ListNode(sum%10);

            p=p.next;

            if(l1!=null){
                l1=l1.next;
            }

            if(l2!=null){
                l2=l2.next;
            }

        }

        //此时表示最高位的进位，如果最高位的进位不为0，则需要新增一个节点
        if(carry>0){
            p.next=new ListNode(carry);
        }

        return result.next;

    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}