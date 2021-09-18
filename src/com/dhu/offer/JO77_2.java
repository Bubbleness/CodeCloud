package com.dhu.offer;

public class JO77_2 {

    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode slow = head , fast = head , pre = slow;
        while(fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null)
                fast = fast.next;
        }

        ListNode l1 = head , l2 = slow;
        pre.next = null;

        ListNode left = sortList(l1);
        ListNode right = sortList(l2);
        ListNode newHead = merge(left,right);
        return newHead;

    }


    public static ListNode merge(ListNode l1 , ListNode l2){

        ListNode head = new ListNode(-1);
        ListNode r = head;

        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                r.next = l1;
                r = l1;
                l1 = l1.next;
            }else{
                r.next = l2;
                r = l2;
                l2 = l2.next;
            }
        }

        while(l1 != null){
            r.next = l1;
            r = l1;
            l1 = l1.next;
        }

        while(l2 != null){
            r.next = l2;
            r = l2;
            l2 = l2.next;
        }

        return head.next;
    }
}
