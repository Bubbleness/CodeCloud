package com.dhu.offer;

public class JO78_2 {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        if(lists.length == 2)
            return merge(lists[0],lists[1]);

        ListNode head = merge(lists[0],lists[1]);
        for(int i=2;i<lists.length;i++){
            head = merge(head,lists[i]);
        }
        return head;
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
