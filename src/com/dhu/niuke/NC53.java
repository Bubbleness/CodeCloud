package com.dhu.niuke;

public class NC53 {

    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if(head == null)
            return head;
        if(n == 0)
            return head;

        if(n == 1 && head.next == null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        if(n == 1){
            while(fast.next != null){
                slow = fast;
                fast = fast.next;
            }
            slow.next = null;
            return head;
        }

        while(n > 0){
            fast = fast.next;
            n--;
        }

        if(fast == null)
            return head.next;

        while(fast.next != null){

            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;

    }
}
