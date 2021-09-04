package com.dhu.niuke;

public class NC33 {

    public ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode r1 = list1;
        ListNode r2 = list2;
        ListNode res = new ListNode(-1);
        ListNode r = res;

        while(r1!=null && r2!=null){
            if(r1.val <= r2.val){
                r.next = r1;
                r = r1;
                r1 = r1.next;
            }else{
                r.next = r2;
                r = r2;
                r2 = r2.next;
            }
        }

        while (r1!=null){
            r.next = r1;
            r = r1;
            r1 = r1.next;
        }

        while (r2!=null){
            r.next = r2;
            r = r2;
            r2 = r2.next;
        }

        return res.next;
    }
}
