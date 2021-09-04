package com.dhu.niuke;

import java.util.Stack;

public class NC40 {

    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here

        if(head1 == null && head2 == null)
            return null;
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

//        ListNode r1 = reverseList(head1);
//        ListNode r2 = reverseList(head2);
        ListNode r1 = ReverseList(head1);
        ListNode r2 = ReverseList(head2);
        ListNode res = new ListNode(-1);
        res.next = null;
        ListNode r = res;

        int e = 0;
        while(r1 != null && r2 != null){
            int temp = r1.val+r2.val+e;
            r.next = new ListNode(temp%10);
            r = r.next;
            e = temp/10;

            r1 = r1.next;
            r2 = r2.next;
        }

        while(r1 != null){
            int temp1 = r1.val+e;
            r.next = new ListNode(temp1%10);
            r = r.next;
            e = temp1 / 10;
            r1 = r1.next;
        }

        while(r2 != null){
            int temp2 = r2.val+e;
            r.next = new ListNode(temp2%10);
            r = r.next;
            e = temp2 / 10;
            r2 = r2.next;
        }

        if(e != 0){
            r.next = new ListNode(e);
            r = r.next;
        }

        return ReverseList(res.next);

    }

    public ListNode reverseList(ListNode head){

        if(head == null || head.next == null){
            return head;
        }

        ListNode reverse = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack= new Stack<>();
        //把链表节点全部摘掉放到栈中
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty())
            return null;
        ListNode node = stack.pop();
        ListNode dummy = node;
        //栈中的结点全部出栈，然后重新连成一个新的链表
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        //最后一个结点就是反转前的头结点，一定要让他的next
        //等于空，否则会构成环
        node.next = null;
        return dummy;
    }



}
