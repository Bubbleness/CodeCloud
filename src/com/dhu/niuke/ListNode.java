package com.dhu.niuke;

public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }

    public static ListNode createList(int[] nums){

        ListNode head = new ListNode(-1);
        ListNode r = head;
        for(int num : nums){

            ListNode s = new ListNode(num);
            r.next = s;
            r = s;
        }

        return head.next;

    }

    public static void display(ListNode head){
        if(head == null)
            return;

        ListNode p = head;
        System.out.print("head ->");
        while(p != null){
            System.out.print(p.val + " -> ");
            p = p.next;
        }
        System.out.print("tail");
    }
}