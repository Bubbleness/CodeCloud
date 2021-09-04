package com.dhu.niuke;

public class NC24 {


    public ListNode deleteDuplicates (ListNode head) {
        // write code here

        if(head == null || head.next == null)
            return head;

        ListNode pre,p;

        //消除头部重复的元素
        while(head.next != null && head.val == head.next.val){

            head = head.next;
            if(head.next == null)
                return null;
            if(head.next != null && head.val != head.next.val){
                head = head.next;
            }
        }

        pre = head;
        p = head.next;

        while (p != null){
            while(p.next != null && p.val == p.next.val){
                if(p.next.next == null){
                    pre.next = null;
                    return head;
                }

                p = p.next;
                if(p.next != null && p.val != p.next.val)
                    p = p.next;
            }
            pre.next = p;
            pre = p;
            p = p.next;
        }
        pre.next = null;
        return head;
    }
}
