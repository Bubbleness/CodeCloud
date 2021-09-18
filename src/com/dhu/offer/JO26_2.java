package com.dhu.offer;

import java.util.Deque;
import java.util.LinkedList;

public class JO26_2 {

    public void reorderList(ListNode head) {

        if(head == null)
            return;

        Deque<ListNode> dq = new LinkedList<>();
        ListNode p = head;
        while(p != null){
            dq.offer(new ListNode(p.val));
            p = p.next;
        }

        head.next = null;
        ListNode r = head;
        while (!dq.isEmpty()){

            ListNode temp1 = dq.pollFirst();
            r.next = temp1;
            r = temp1;


            ListNode temp2 = dq.pollLast();
            r.next = temp2;
            r = temp2;
        }
    }
}
