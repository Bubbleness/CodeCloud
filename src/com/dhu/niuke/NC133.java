package com.dhu.niuke;

import java.util.List;
import java.util.Scanner;

public class NC133 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
            nums[i] = sc.nextInt();
        ListNode head = ListNode.createList(nums);
        ListNode.display(head);
        System.out.println();
        NC133 nc = new NC133();
        ListNode res = nc.oddEvenList(head);
        ListNode.display(res);
    }

    public ListNode oddEvenList (ListNode head) {

        if(head == null)
            return head;

        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);

        ListNode p = head,ro = odd,re = even,q;

        while(p != null){

            q = p.next;

            ro.next = p;
            ro = p;
            p.next = null;
            p = q;


            if(p == null)
                break;
            q = p.next;
            re.next = p;
            re = p;
            p.next = null;
            p = q;
        }

        ro.next = even.next;
        return odd.next;
    }
}
