package com.dhu.niuke;

import java.util.Stack;

public class NC50 {

    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here

        if(head == null)
            return null;
        if(k == 0)
            return head;

        Stack<ListNode> stack = new Stack<>();
        ListNode res = new ListNode(-1);
        ListNode r = res;
        ListNode p,q = null;
        int count = 0;

        while(true){

            while(count < k){
                stack.push(head);
                head = head.next;
                count++;
                if(head == null)
                    break;
            }

            if(count == k){
                while(!stack.isEmpty()){
                    r.next = stack.pop();
                    r = r.next;
                    r.next = null;
                }
            }

            if(head == null)
                break;
            count = 0;
        }

        while(!stack.isEmpty()){
            q = stack.pop();
        }

        r.next = q;
        return res.next;

    }


    public ListNode reverseList(ListNode head){

        if(head == null || head.next == null)
            return head;
        ListNode reverse = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }
}
